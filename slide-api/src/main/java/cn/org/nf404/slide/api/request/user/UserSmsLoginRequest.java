package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author DingXing wildhunt_geralt@foxmail.com
 * @since 2019/3/17 上午12:13
 */
@ApiModel("短信登录验证")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserSmsLoginRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 7153615199078150067L;

    @ApiModelProperty(value = "手机号", required = true)
    private String mobile;

    @ApiModelProperty(value = "验证码", required = true)
    private String code;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(mobile, "mobile");
        ParamUtil.isPhoneNumber(mobile);
        ParamUtil.nonNull(code, "verify.code");
    }
}
