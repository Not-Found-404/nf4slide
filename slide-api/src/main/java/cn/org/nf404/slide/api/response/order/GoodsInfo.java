package cn.org.nf404.slide.api.response.order;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = 3476296487616312995L;

    private Long id;

    private String name;

    private String imageUrl;

    private Long stockInventory;

    private Long originalAmount;

    private String unit;

    private Long categoryId;

    private String barcode;

    private Map<String, Object> attribute;
}
