package cn.org.nf404.slide.common.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * 基础分页请求类
 *
 * @author dx DingXing
 * @since 2020-01-01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractPagingRequest extends AbstractRequest {

    private Integer pageNo;

    private Integer pageSize;

    private Integer offset;

    private Integer limit;

    @Override
    public void checkParam() {
        super.checkParam();
        if (Objects.isNull(pageSize) || pageSize < 0) {
            pageSize = 20;
        }
        limit = pageSize;

        if (Objects.isNull(pageNo) || pageNo <= 0) {
            offset = 0;
        } else {
            offset = (pageNo - 1) * pageSize;
        }
    }
}
