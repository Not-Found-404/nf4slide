package cn.org.nf404.slide.api.response.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class AddressInfo implements Serializable {
    private static final long serialVersionUID = 7681621459348055227L;

    private Long endpointAddressId;

    private String detailAddress;

    private String fullDetailAddress;

    private String phone;
}
