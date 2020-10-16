package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.common.model.enums.ModelStatusEnum;
import cn.org.nf404.slide.server.domain.model.User;
import cn.org.nf404.slide.server.repository.converter.DoConverter;
import cn.org.nf404.slide.server.repository.dao.UserDao;
import cn.org.nf404.slide.server.repository.entity.UserDO;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author dx DingXing
 * @since 2020-09-28
 */
@Repository
@AllArgsConstructor
public class UserRepository {
    private final UserDao userDao;

    private final DoConverter converter;

    public User save(User user) {
        UserDO userDO = converter.convert(user);
        userDO.setCreatedAt(new Date());
        userDO.setUpdatedAt(new Date());
        userDO.setStatus(ModelStatusEnum.INIT.name());

        return converter.convert(this.userDao.save(userDO));
    }

    public User findByPhoneAndPass(String phone, String password) {

        Specification<UserDO> specification = Specification.where((Specification<UserDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.<Integer>get("phone"), phone));
            list.add(cb.equal(root.<Integer>get("password"), password));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });


        Optional<UserDO> one = userDao.findOne(specification);
        return converter.convert(one.orElse(null));
    }
}
