package cn.org.nf404.slide.web.bean.dto.slide;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@Data
public class SlideCreateRequestDTO implements Serializable {
    private static final long serialVersionUID = 5720988991335148614L;

    private Long folderId;
}
