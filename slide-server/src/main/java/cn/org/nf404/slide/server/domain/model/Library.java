package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.api.enums.OwnerTypeEnum;
import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dx DingXing
 * @date 2020-01-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Library extends BaseModel {
    private static final long serialVersionUID = 6634339913902054992L;

    private OwnerTypeEnum ownerType;

    private Long ownerId;

    private String name;

    private String description;

    private String accessLevel;
}
