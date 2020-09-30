package cn.org.nf404.slide.web.bean.dto.order;

import cn.org.nf404.slide.api.request.fulfillment.FulfillmentOrderLineCreateParam;
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
public class FulfillmentOrderCreateRequestDTO implements Serializable {
    private static final long serialVersionUID = -7237712331041040422L;

    private Long dealerId;

    private String remark;

    private List<FulfillmentOrderLineCreateParam> orderLineLists;
}
