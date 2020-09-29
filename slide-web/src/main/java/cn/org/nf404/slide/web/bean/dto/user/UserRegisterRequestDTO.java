package cn.org.nf404.slide.web.bean.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-28
 */
@Data
public class UserRegisterRequestDTO implements Serializable {
    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "注册验证码", required = true)
    private String code;
}
