package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseModel implements Serializable {
    private static final long serialVersionUID = 8500173055907840672L;

    private Long pid;

    private String name;

    private Integer level;

    private Boolean hasChild;
}
