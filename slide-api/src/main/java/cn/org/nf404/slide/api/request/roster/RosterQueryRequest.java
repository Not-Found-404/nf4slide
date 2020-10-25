package cn.org.nf404.slide.api.request.roster;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RosterQueryRequest extends AbstractRequest {
    private static final long serialVersionUID = -1809942031858803228L;

    /**
     * 组id
     */
    private String groupId;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(groupId, "groupId");
    }
}
