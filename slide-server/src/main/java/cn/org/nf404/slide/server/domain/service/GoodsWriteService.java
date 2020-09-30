package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.request.goods.GoodsCreateRequest;
import cn.org.nf404.slide.server.domain.converter.GoodsConverter;
import cn.org.nf404.slide.server.domain.model.Goods;
import cn.org.nf404.slide.server.repository.impl.GoodsRepository;
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
public class GoodsWriteService {
    private static final Long DEFAULT_CATEGORY_ID = 0L;
    private GoodsRepository goodsRepository;
    private GoodsConverter goodsConverter;

    public Long create(GoodsCreateRequest request) {
        Goods toCreate = this.goodsConverter.request2Model(request);

        // init
        if (null == toCreate.getCategoryId()) {
            toCreate.setCategoryId(DEFAULT_CATEGORY_ID);
        }
        toCreate.setStockInventory(0L);

        return this.goodsRepository.save(toCreate);
    }
}
