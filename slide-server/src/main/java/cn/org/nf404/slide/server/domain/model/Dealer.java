package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Dealer extends BaseModel implements Serializable {
    private static final long serialVersionUID = -6894371678865979087L;

    private String name;

    private String username;

    private String remark;

    private Address address;
}
