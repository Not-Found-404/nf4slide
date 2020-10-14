package cn.org.nf404.slide.api.response.slide;

import cn.org.nf404.slide.api.enums.SlideContentTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@Data
public class SlideContentInfo implements Serializable {
    private static final long serialVersionUID = 7439406645783041982L;

    /**
     * 幻灯片id
     */
    private Long slideId;

    /**
     * 幻灯片名
     */
    private String slideName;

    /**
     * 幻灯片类型
     */
    private String contentType;

    /**
     * 幻灯片内容
     */
    private String contentText;

    /**
     * url
     */
    private String contextUrl;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 额外配置
     */
    private Map<String, String> config;
}
