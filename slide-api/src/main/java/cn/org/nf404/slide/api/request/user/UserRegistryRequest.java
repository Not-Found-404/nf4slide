package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


/**
 * @author dx DingXing
 * @date 2020.1.22
 */
@ApiModel("注册")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRegistryRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -493769781089893823L;
    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty(value = "手机号", required = true)
    private String mobile;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "注册验证码", required = true)
    private String code;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(this.mobile, "mobile");
        ParamUtil.isPhoneNumber(this.mobile);
        ParamUtil.nonNull(this.code, "verify.code");
        ParamUtil.nonNull(this.password, "password");
    }

}
