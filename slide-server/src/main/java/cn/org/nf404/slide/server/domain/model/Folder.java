package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 文件目录
 *
 * @author dx DingXing
 * @since 2020-01-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Folder extends BaseModel {
    private static final long serialVersionUID = 7333420308624966718L;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 文件库id
     */
    private Long libraryId;

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
    private List<Folder> children;

    /**
     * 目录下的幻灯片
     */
    private List<Slide> slides;

}
