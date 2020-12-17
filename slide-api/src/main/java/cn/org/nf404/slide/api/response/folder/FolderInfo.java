package cn.org.nf404.slide.api.response.folder;

import cn.org.nf404.slide.api.enums.OwnerTypeEnum;
import cn.org.nf404.slide.api.response.slide.SlideInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ghy Arcry
 * @since 2020-10-12
 */
@Data
public class FolderInfo implements Serializable {

    private static final long serialVersionUID = 6519760163156637494L;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 当前folder的类型对应的userId或teamId
     */
    private Long ownerId;

    /**
     * 当前folder的类型
     */
    private String ownerType;

    /**
     * 目录名
     */
    private String name;

    /**
     * 父目录id
     */
    private Long pid;

    /**
     * 子目录
     */
    private List<FolderInfo> children;

    /**
     * 目录下的幻灯片
     */
    private List<SlideInfo> slides;

}
