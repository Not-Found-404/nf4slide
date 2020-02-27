package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@ApiModel("手机号查重")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExistPhoneRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -1176704228274943634L;
    @ApiModelProperty("要判断的手机号")
    private String mobile;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(this.mobile,"mobile");
        ParamUtil.isPhoneNumber(mobile);
    }
}
