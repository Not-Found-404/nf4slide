package cn.org.nf404.slide.web.bean.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-09-28
 */
@Data
@ApiModel("登录信息")
public class UserLoginRequestDTO implements Serializable {
    private static final long serialVersionUID = -7950820585021126140L;

    @ApiModelProperty(value = "识别", required = true)
    private String identify;

    @ApiModelProperty(value = "密码或者验证码", required = true)
    private String token;
}
