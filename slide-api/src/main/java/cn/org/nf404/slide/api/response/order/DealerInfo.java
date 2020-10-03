package cn.org.nf404.slide.api.response.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class DealerInfo implements Serializable {
    private static final long serialVersionUID = -6947935387264946046L;

    private Long id;

    private String name;

    private String username;

    private String remark;

    private AddressInfo address;
}
