package cn.org.nf404.slide.server.domain.service;

import cn.org.nf404.slide.api.request.dealer.DealerCreateRequest;
import cn.org.nf404.slide.server.domain.converter.AddressConverter;
import cn.org.nf404.slide.server.domain.converter.DealerConverter;
import cn.org.nf404.slide.server.domain.model.Address;
import cn.org.nf404.slide.server.domain.model.Dealer;
import cn.org.nf404.slide.server.repository.impl.DealerRepository;
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
public class DealerWriteService {
    private final DealerRepository dealerRepository;
    private final DealerConverter dealerConverter;
    private final AddressConverter addressConverter;

    public Long create(DealerCreateRequest request) {
        Dealer toCreate = this.dealerConverter.request2Model(request);
        Address dealerAddress = this.addressConverter.request2Model(request);

        toCreate.setAddress(dealerAddress);
        toCreate.setUsername(toCreate.getName());

        return dealerRepository.save(toCreate);
    }
}
