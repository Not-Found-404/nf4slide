package cn.org.nf404.slide.api.request.fulfillment;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author dx DingXing
 * @date 2020-09-30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FulfillmentOrderCreateRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -7237712331041040422L;

    private Long dealerId;

    private String remark;

    private Long acceptorId;

    private List<FulfillmentOrderLineCreateParam> orderLineLists;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(dealerId, "dealer.id");
        ParamUtil.nonNull(acceptorId, "acceptor.id");
        ParamUtil.nonEmpty(orderLineLists, "order.line");

        orderLineLists.forEach(e -> {
            ParamUtil.nonNull(e.getGoodsId(), "goods.id");
            ParamUtil.nonNull(e.getQuantity(), "goods.quantity");
        });
    }
}
