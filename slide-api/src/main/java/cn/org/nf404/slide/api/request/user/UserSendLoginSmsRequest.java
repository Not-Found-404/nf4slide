package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author DingXing wildhunt_geralt@foxmail.com
 * @date 2019/3/17 上午12:05
 */
@ApiModel("发送登录验证短信")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserSendLoginSmsRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 4891199107857827683L;

    @ApiModelProperty(value = "手机号",required = true)
    private String mobile;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(mobile,"mobile");
        ParamUtil.isPhoneNumber(mobile);
    }
}
