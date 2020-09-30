package cn.org.nf404.slide.api.request.goods;

import cn.org.nf404.slide.common.model.request.AbstractRequest;
import lombok.*;

import java.util.Map;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GoodsCreateRequest extends AbstractRequest {
    private static final long serialVersionUID = -4584119672706576102L;

    private String name;

    private String imageUrl;

    private Long originalAmount;

    private String unit;

    private Long categoryId;

    private String barcode;

    private Map<String, Object> attribute;
}
