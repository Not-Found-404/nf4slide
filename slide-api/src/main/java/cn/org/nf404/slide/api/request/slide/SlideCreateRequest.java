package cn.org.nf404.slide.api.request.slide;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SlideCreateRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -8929355714463813808L;

    private Long folderId;

    private Long creatorId;

    private String slideName;
}
