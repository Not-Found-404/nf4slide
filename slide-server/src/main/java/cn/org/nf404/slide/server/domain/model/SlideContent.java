package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.api.enums.SlideContentTypeEnum;
import cn.org.nf404.slide.common.model.domain.BaseModel;
import cn.org.nf404.slide.common.utils.JsonHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 幻灯片内容
 *
 * @author dx DingXing
 * @date 2020-01-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("unused")
public class SlideContent extends BaseModel {
    private static final long serialVersionUID = 6771338775716345732L;

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
    private SlideContentTypeEnum contentType;

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
    private Map<String, Object> config;

    public static SlideContent init() {
        SlideContent content = new SlideContent();
        content.setVersion(0);
        content.setContentText(Strings.EMPTY);
        content.setContentType(SlideContentTypeEnum.TEXT);
        content.setConfig(Maps.newHashMap());
        return content;
    }
}
