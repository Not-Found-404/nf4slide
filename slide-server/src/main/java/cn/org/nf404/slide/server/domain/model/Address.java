package cn.org.nf404.slide.server.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
public class Address implements Serializable {
    private static final long serialVersionUID = -2452133803680908406L;

    private Long endpointAddressId;

    private String detailAddress;

    private String fullDetailAddress;

    private String phone;
}
