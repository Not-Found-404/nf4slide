package cn.org.nf404.slide.server.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
public class Price implements Serializable {
    private static final long serialVersionUID = -1426821291198476168L;

    private Long paidAmount;

    private Long originalAmount;

    public static Price of(Long originalAmount, Long paidAmount) {
        Price price = new Price();
        price.setOriginalAmount(originalAmount);
        price.setPaidAmount(paidAmount);
        return price;
    }
}
