package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


/**
 * @author Dx DingXing
 */
@ApiModel("登录")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserLoginRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 6488434159625540269L;
    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户类型")
    private Integer type;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(this.mobile, "mobile");
        ParamUtil.nonNull(this.password, "password");
    }
}
