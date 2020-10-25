package cn.org.nf404.slide.api.request.folder;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import cn.org.nf404.slide.common.utils.ParamUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ghy Arcry
 * @since 2020-10-12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FolderQueryRequest extends AbstractRequest {
    private static final long serialVersionUID = -3736896853691785544L;
    /**
     * id
     */
    private Long id;

    @Override
    public void checkParam() {
        super.checkParam();
        ParamUtil.nonNull(id,"id");
    }
}
