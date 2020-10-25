package cn.org.nf404.slide.web.bean.dto.slide;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-16
 */
@Data
public class SlideRenderQueryRequestDTO implements Serializable {
    private static final long serialVersionUID = 4934720130645398393L;

    private String slideName;
}
