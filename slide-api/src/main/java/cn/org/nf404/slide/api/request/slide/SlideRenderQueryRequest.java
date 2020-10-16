package cn.org.nf404.slide.api.request.slide;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SlideRenderQueryRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 8380549185426542437L;

    private String slideName;
}
