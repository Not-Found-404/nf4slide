package cn.org.nf404.slide.server.component.sequence;

import cn.org.nf404.slide.common.model.exception.ServiceException;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author dx DingXing
 * @since 2020-10-23
 */
@Slf4j
@Repository
public class SharedSequenceRepository {

    @Resource(name = "masterJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * 200 ids for each step
     */
    private static final Long STEP = 100L;

    private static final Integer MAX_RETRY_TIMES = 3;

    private final static String CREATE_SQL = "INSERT INTO `shard_sequence` (`name`, `value`, `updated_at`) VALUES (?, ?, now());";

    private final static String UPDATE_SQL = "UPDATE `shard_sequence` SET `value` = ?,`updated_at` = now()  WHERE `name`= ? and `value`= ? ;";

    private final static String SELECT_SQL = "SELECT `name`, `value`, `updated_at` FROM `shard_sequence` WHERE `name` = ? ";

    @SuppressWarnings("WeakerAccess")
    public SequenceRange nextRange(String name) {
        for (int i = 0; i < MAX_RETRY_TIMES + 1; i++) {
            long current = this.getOrElseCreate(name);
            long nextValue = current + STEP;
            int update = this.jdbcTemplate.update(UPDATE_SQL, nextValue, name, current);
            if (0 == update) {
                try {
                    new CountDownLatch(1).await(10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    // Let it go
                }
                continue;
            }
            return new SequenceRange(current + 1, nextValue);
        }
        throw ServiceException.of("too.many.retries", name);
    }


    private Long getOrElseCreate(String name) {
        try {
            Long current = this.jdbcTemplate.query(SELECT_SQL, new Object[]{name}, (rs, rowNum) -> rs.getLong("value")).stream().findFirst().orElse(null);
            if (null == current) {
                synchronized (this) {
                    try {
                        this.jdbcTemplate.update(CREATE_SQL, name, 100L);
                        return 100L;
                    } catch (DuplicateKeyException e) {
                        log.error("[SHARD SEQUENCE] key already exist, key:{}", name);
                        return this.jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{name}, (rs, rowNum) -> rs.getLong("value"));
                    }
                }
            }
            return current;
        } catch (Exception e) {
            log.error("[SHARD SEQUENCE] failed to init key:{}, \ncause:{}", name, Throwables.getStackTraceAsString(e));
            throw ServiceException.of("sequence.init.key.failed", name);
        }
    }
}
