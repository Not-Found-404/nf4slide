package cn.org.nf404.slide.web.bean.dto.goods;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
public class GoodsCreateRequestDTO implements Serializable {
    private static final long serialVersionUID = -8721391158750577378L;

    private String name;

    private String imageUrl;

    private Long originalAmount;

    private String unit;

    private Long categoryId;

    private String barcode;

    private Map<String, Object> attribute;
}
