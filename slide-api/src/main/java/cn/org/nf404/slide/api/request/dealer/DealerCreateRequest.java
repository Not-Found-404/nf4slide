package cn.org.nf404.slide.api.request.dealer;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import lombok.*;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DealerCreateRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = -5722238761319261015L;

    private Long endpointAddressId;

    private String detailAddress;

    private String fullDetailAddress;

    private String phone;

    private String name;
}
