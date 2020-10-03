package cn.org.nf404.slide.api.request.dealer;

import cn.org.nf404.slide.common.model.request.AbstractPagingRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FulfillmentOrderPagingRequest extends AbstractPagingRequest implements Serializable {
    private static final long serialVersionUID = 6881782298178010537L;

    private Long addressId;

    private Long dealerId;

    private Date beginAt;

    private Date endAt;

}
