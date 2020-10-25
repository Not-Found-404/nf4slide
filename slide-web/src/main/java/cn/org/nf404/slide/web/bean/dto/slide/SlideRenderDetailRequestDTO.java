package cn.org.nf404.slide.web.bean.dto.slide;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@Data
public class SlideRenderDetailRequestDTO implements Serializable {
    private static final long serialVersionUID = -2593792298446151887L;

    private Long slideId;
}
