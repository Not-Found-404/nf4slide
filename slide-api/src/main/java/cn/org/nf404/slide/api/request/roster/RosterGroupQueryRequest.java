package cn.org.nf404.slide.api.request.roster;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RosterGroupQueryRequest extends AbstractRequest {
    private static final long serialVersionUID = -9200164056830791398L;
}
