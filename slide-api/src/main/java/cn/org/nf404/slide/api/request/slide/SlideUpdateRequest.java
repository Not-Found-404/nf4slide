package cn.org.nf404.slide.api.request.slide;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Map;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SlideUpdateRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 3768088281010674454L;

    private Long updateBy;

    private Long slideId;

    private String slideName;

    private String slideContent;

    private String contentType;

    /**
     * 播放配置
     */
    private Map<String, String> config;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(slideId, "slideId");
        ParamUtil.nonNull(updateBy, "updateBy");
    }

    public Boolean updateContent() {
        return this.slideContent != null || this.config != null;
    }
}
