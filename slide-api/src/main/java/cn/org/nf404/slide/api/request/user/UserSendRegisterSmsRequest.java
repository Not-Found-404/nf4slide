package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020.1.22
 */
@ApiModel("发短信")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserSendRegisterSmsRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 1651194469071585519L;

    @ApiModelProperty(value = "发到哪个手机号", required = true)
    private String mobile;

    @Override
    public void checkParam() {
        ParamUtil.nonNull(this.mobile, "mobile.not.be.null");
        ParamUtil.isPhoneNumber(mobile);
    }
}
