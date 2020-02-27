package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


@ApiModel("用户名查重")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class ExistUsernameRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -6230132454851537797L;

    @ApiModelProperty("要判断的昵称")
    private String username;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(this.username,"username");
    }
}
