package cn.org.nf404.slide.api.request.slide;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SlideRenderDetailRequest extends AbstractRequest {
    private static final long serialVersionUID = -537705217705758358L;
    private Long slideId;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(this.slideId, "slideId");
    }
}
