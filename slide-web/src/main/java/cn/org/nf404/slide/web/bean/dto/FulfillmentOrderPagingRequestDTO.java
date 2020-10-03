package cn.org.nf404.slide.web.bean.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author dx DingXing
 * @date 2020-10-02
 */
@Data
public class FulfillmentOrderPagingRequestDTO {

    private Long addressId;

    private Long dealerId;

    private Date beginAt;

    private Date endAt;

    private Integer pageSize;

    private Integer pageNo;
}
