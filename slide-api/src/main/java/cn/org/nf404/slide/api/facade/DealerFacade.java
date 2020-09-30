package cn.org.nf404.slide.api.facade;

import cn.org.nf404.slide.api.request.dealer.DealerCreateRequest;
import cn.org.nf404.slide.common.model.request.Response;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
public interface DealerFacade {
    Response<Long> create(DealerCreateRequest request);
}
