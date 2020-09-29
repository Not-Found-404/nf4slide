package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * 幻灯片model
 *
 * @author dx DingXing
 * @date 2020-01-11
 */
@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
public class Slide extends BaseModel {
    private static final long serialVersionUID = -2995114137354817019L;

    /**
     * 文件库id
     */
    private Long libraryId;

    /**
     * 目录id
     */
    private Long folderId;

    /**
     * 幻灯片名
     */
    private String name;

    /**
     * 键鼠信息
     */
    private String description;

    /**
     * 访问等级
     */
    private String accessLevel;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 幻灯片内容
     */
    private SlideContent content;

    /**
     * 编辑参与人
     */
    private Set<String> authors;
}


