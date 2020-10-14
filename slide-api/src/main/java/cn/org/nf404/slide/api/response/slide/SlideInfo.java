package cn.org.nf404.slide.api.response.slide;

import cn.org.nf404.slide.api.enums.AccessLevelEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author dx DingXing
 * @since 2020-10-14
 */
@Data
public class SlideInfo implements Serializable {
    private static final long serialVersionUID = -7011736318083182467L;


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
    private SlideContentInfo content;

    /**
     * 历史版本
     */
    private List<SlideContentInfo> historyContent;

    /**
     * 编辑参与人
     */
    private Set<String> authors;
}
