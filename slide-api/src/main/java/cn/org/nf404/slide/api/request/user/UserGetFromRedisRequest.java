package cn.org.nf404.slide.api.request.user;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

/**
 * @author DingXing wildhunt_geralt@foxmail.com
 * @date 2019/4/18
 */
@ApiModel("读取redis参数")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserGetFromRedisRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -5927232603035387246L;

    private String key;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(key,"key");
    }
}
