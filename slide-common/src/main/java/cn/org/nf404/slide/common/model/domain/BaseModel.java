package cn.org.nf404.slide.common.model.domain;

import cn.org.nf404.slide.common.model.enums.ModelStatusEnum;
import cn.org.nf404.slide.common.utils.JsonHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 基础model类
 *
 * @author dx DingXing
 * @date 2020-01-01
 */
@SuppressWarnings("unused")
@Data
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = -8969680472597387486L;

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 状态
     */
    private ModelStatusEnum status = ModelStatusEnum.INIT;

    /**
     * 额外信息的map存储
     */
    private Map<String, Object> extra;

    /**
     * 额外信息
     */
    @JsonIgnore
    private String extraJson;

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
        if (extra == null || extra.isEmpty()) {
            this.extraJson = null;
        } else {
            this.extraJson = JsonHelper.toJson(extra);
        }
    }

    public void setExtraJson(String extraJson) {
        this.extraJson = extraJson;
        if (!StringUtils.isEmpty(extraJson)) {
            extra = JsonHelper.toMap(extraJson);
        } else {
            extra = Maps.newHashMap();
        }
    }
}
