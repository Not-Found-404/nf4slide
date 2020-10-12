package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

/**
 * @author DingXing wildhunt_geralt@foxmail.com
 * @since 2019/6/7
 */
@ApiModel("注销请求")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserLogoutRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 8390097532392781547L;
    private Long userId;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(userId,"user.id");
    }
}
