package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


@ApiModel("用户信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FindSingleUserRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 9213294151679558866L;
    @ApiModelProperty(value = "用户id",hidden = true)
    private Long userId;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(userId,"user.id");
    }
}
