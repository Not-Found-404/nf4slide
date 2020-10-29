package cn.org.nf404.slide.server.component.sequence;

import cn.org.nf404.slide.server.repository.entity.SharedSequenceDO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author dx DingXing
 * @since 2020-10-23
 */
@Repository
public class SharedSequenceRepository {

    @Resource(name = "masterJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    private final static String CREATE_SQL = "INSERT INTO `shard_sequence` (`name`, `value`, `updated_at`) VALUES (?, ?, now());";

    private final static String UPDATE_SQL = "UPDATE `shard_sequence` SET `value` = ?,`updated_at` = now()  WHERE `name`= ? and `value`= ? ;";

    private final static String SELECT_SQL = "SELECT `name`, `value`, `updated_at` FROM `shard_sequence` WHERE `name` = ? ";


    /**
     * 200 ids for each step
     */
    private static final Long STEP = 200L;

    @SuppressWarnings("WeakerAccess")
    public SequenceRange nextRange(String name) {

        return null;
    }

    private SharedSequenceDO initSequenceByName(String name) {
        SharedSequenceDO create = new SharedSequenceDO(name, 1L, new Date());
        int update = this.jdbcTemplate.update(CREATE_SQL, name, 1);
        if (0 == update) {

        }
        return create;
    }
}
