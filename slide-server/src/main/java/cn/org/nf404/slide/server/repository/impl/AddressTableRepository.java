package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.server.domain.model.AddressTable;
import cn.org.nf404.slide.server.repository.converter.AddressDoConverter;
import cn.org.nf404.slide.server.repository.dao.AddressTableDao;
import cn.org.nf404.slide.server.repository.entity.AddressTableDO;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Repository
@AllArgsConstructor
@SuppressWarnings("Duplicates")
public class AddressTableRepository {
    private AddressTableDao addressTableDao;
    private AddressDoConverter addressDOConverter;

    public List<AddressTable> findByPid(Long pid) {
        Specification<AddressTableDO> specification = Specification.where((Specification<AddressTableDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.<Integer>get("pid"), pid));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });

        List<AddressTableDO> allChildDO = this.addressTableDao.findAll(specification);
        if (null == allChildDO || allChildDO.isEmpty()) {
            return Lists.newArrayListWithCapacity(0);
        }


//        List<Long> pidList = allChildDO.stream().map(AddressTableDO::getId).collect(Collectors.toList());
//        specification = Specification.where((Specification<AddressTableDO>) (root, cq, cb) -> {
//            List<Predicate> list = new ArrayList<>();
//            list.add(root.<Long>get("pid").in(pidList));
//            return cq.where(list.toArray(new Predicate[0])).getRestriction();
//        });
//
//        List<AddressTableDO> allSubChildDO = this.addressTableDao.findAll(specification);
//        List<AddressTable> allSubChild = allSubChildDO.stream().map(this.addressDOConverter::do2Model)
//                .collect(Collectors.toList());
//
//        Multimap<Long, AddressTable> pidToChild = ArrayListMultimap.create();
//        allSubChild.forEach(e -> pidToChild.put(e.getPid(), e));
//

        return allChildDO.stream()
                .map(e -> {
                    AddressTable child = this.addressDOConverter.do2Model(e);
                    Collection<AddressTable> subChild = null;
//                            pidToChild.get(child.getId());
                    if (null == subChild || subChild.isEmpty()) {
                        child.setChild(Lists.newArrayListWithCapacity(0));
                    } else {
                        child.setChild(Lists.newArrayList(subChild));
                    }
                    return child;
                })
                .collect(Collectors.toList());
    }

    public AddressTable findById(Long id) {
        Specification<AddressTableDO> specification = Specification.where((Specification<AddressTableDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.<Integer>get("id"), id));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });

        Optional<AddressTableDO> one = this.addressTableDao.findOne(specification);
        if (!one.isPresent()) {
            return null;
        }
        AddressTableDO addressTableDO = one.get();
        AddressTable result = this.addressDOConverter.do2Model(addressTableDO);

//        specification = Specification.where((Specification<AddressTableDO>) (root, cq, cb) -> {
//            List<Predicate> list = new ArrayList<>();
//            list.add(cb.equal(root.<Integer>get("pid"), id));
//            return cq.where(list.toArray(new Predicate[0])).getRestriction();
//        });
//
//        List<AddressTableDO> child = this.addressTableDao.findAll(specification);
//        result.setChild(child.stream().map(this.addressDOConverter::do2Model).collect(Collectors.toList()));
        return result;
    }

    public void save(List<AddressTable> list) {
        List<AddressTableDO> all = list.stream().map(this.addressDOConverter::model2Do)
                .collect(Collectors.toList());

        this.addressTableDao.saveAll(all);
    }
}
