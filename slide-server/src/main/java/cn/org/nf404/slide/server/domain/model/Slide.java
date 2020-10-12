package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.api.enums.AccessLevelEnum;
import cn.org.nf404.slide.common.model.domain.BaseModel;
import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

/**
 * 幻灯片model
 *
 * @author dx DingXing
 * @since 2020-01-11
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
    private AccessLevelEnum accessLevel;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 幻灯片内容
     */
    private SlideContent content;

    /**
     * 历史版本
     */
    private List<SlideContent> historyContent;

    /**
     * 编辑参与人
     */
    private Set<String> authors;

    public static Slide init(String name, Long creatorId, Long folderId) {
        Slide slide = new Slide();
        slide.setContent(SlideContent.init());
        slide.setAccessLevel(AccessLevelEnum.NONE);
        slide.setAuthors(Sets.newHashSet(creatorId.toString()));
        slide.setFolderId(folderId);
        slide.setName(name);
        return slide;
    }
}


