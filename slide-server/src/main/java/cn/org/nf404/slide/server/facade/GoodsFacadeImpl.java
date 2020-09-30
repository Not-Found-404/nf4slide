package cn.org.nf404.slide.server.facade;

import cn.org.nf404.slide.api.facade.GoodsFacade;
import cn.org.nf404.slide.api.request.goods.GoodsCreateRequest;
import cn.org.nf404.slide.common.model.request.Response;
import cn.org.nf404.slide.common.utils.FacadeExecutor;
import cn.org.nf404.slide.server.domain.service.GoodsWriteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Slf4j
@Service
@AllArgsConstructor
public class GoodsFacadeImpl implements GoodsFacade {
    private final GoodsWriteService goodsWriteService;

    @Override
    public Response<Long> create(GoodsCreateRequest request) {
        return FacadeExecutor.execute(request,this.goodsWriteService::create);
    }
}
