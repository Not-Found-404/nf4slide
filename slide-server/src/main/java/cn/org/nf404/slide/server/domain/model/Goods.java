package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Map;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Goods extends BaseModel implements Serializable {
    private static final long serialVersionUID = -8294001977206061804L;

    private String name;

    private String imageUrl;

    private Long stockInventory;

    private Long originalAmount;

    private String unit;

    private Long categoryId;

    private String barcode;

    private Map<String, Object> attribute;
}
