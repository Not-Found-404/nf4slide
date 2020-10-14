package cn.org.nf404.slide.web.bean.dto.slide;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@Data
public class SlideUpdateRequestDTO implements Serializable {
    private static final long serialVersionUID = -8986661183389587800L;

    private Long slideId;

    private String slideName;

    private String slideContent;

    private String contentType;

    /**
     * 播放配置
     */
    private Map<String, String> config;
}
