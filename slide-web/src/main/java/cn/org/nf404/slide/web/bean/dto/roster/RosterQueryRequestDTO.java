package cn.org.nf404.slide.web.bean.dto.roster;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Data
@ApiModel("花名册查询参数")
public class RosterQueryRequestDTO implements Serializable {
    private static final long serialVersionUID = -8800893531127332079L;

    /**
     * 组id
     */
    @ApiModelProperty("组id")
    private String groupId;
}
