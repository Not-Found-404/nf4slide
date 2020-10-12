package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.model.request.OperationType;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


/**
 * @author dx DingXing
 * @since 2020.1.22
 */
@ApiModel("注册")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRegistryRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -493769781089893823L;

    private String nickname;

    private String email;

    private String name;

    private String phone;

    private String password;

    private String code;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(this.phone, "mobile");
        ParamUtil.isPhoneNumber(this.phone);
        ParamUtil.nonNull(this.code, "verify.code");
        ParamUtil.nonNull(this.password, "password");
    }

}
