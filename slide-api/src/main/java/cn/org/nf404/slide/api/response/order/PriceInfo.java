package cn.org.nf404.slide.api.response.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class PriceInfo implements Serializable {
    private static final long serialVersionUID = 7112729573860502229L;

    private Long paidAmount;

    private Long originalAmount;
}
