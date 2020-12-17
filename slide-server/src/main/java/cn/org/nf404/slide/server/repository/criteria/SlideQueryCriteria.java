package cn.org.nf404.slide.server.repository.criteria;

import com.google.common.base.Strings;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-16
 */
@Data
@Builder
public class SlideQueryCriteria implements Serializable {
    private static final long serialVersionUID = 4991571617690475273L;

    private Long author;

    private String name;

    private Long folderId;

    public boolean isEmpty() {
        return Strings.isNullOrEmpty(name) && null == folderId && null == folderId;
    }
}
