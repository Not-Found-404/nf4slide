package cn.org.nf404.slide.web.bean.dto.dealer;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
public class DealerCreateRequestDTO implements Serializable {
    private static final long serialVersionUID = 5539010638503744978L;

    private Long endpointAddressId;

    private String detailAddress;

    private String fullDetailAddress;

    private String phone;

    private String name;
}
