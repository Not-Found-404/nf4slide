package cn.org.nf404.slide.api.request.slide;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import lombok.*;

import java.io.Serializable;

import static cn.org.nf404.slide.api.constants.SlideConstant.DEFAULT_SLIDE_NAME;

/**
 * @author dx DingXing
 * @since 2020-10-06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SlideCreateRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -8929355714463813808L;

    private Long folderId;

    private Long creatorId;

    private String slideName;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(folderId, "folderId");
        ParamUtil.nonNull(creatorId, "creatorId");
        if (null == slideName || 0 == slideName.length()) {
            slideName = DEFAULT_SLIDE_NAME;
        }
    }
}
