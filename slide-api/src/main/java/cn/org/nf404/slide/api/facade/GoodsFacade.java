package cn.org.nf404.slide.api.facade;

import cn.org.nf404.slide.api.request.goods.GoodsCreateRequest;
import cn.org.nf404.slide.common.model.request.Response;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
public interface GoodsFacade {
    Response<Long> create(GoodsCreateRequest goodsCreateRequest);
}
