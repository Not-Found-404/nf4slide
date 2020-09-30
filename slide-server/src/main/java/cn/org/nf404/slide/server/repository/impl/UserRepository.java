package cn.org.nf404.slide.server.repository.impl;

import cn.org.nf404.slide.server.domain.model.User;
import cn.org.nf404.slide.server.repository.converter.UserDoConverter;
import cn.org.nf404.slide.server.repository.dao.UserDao;
import cn.org.nf404.slide.server.repository.entity.BaseDO;
import cn.org.nf404.slide.server.repository.entity.UserDO;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author dx DingXing
 * @date 2020-09-28
 */
@Repository
@AllArgsConstructor
public class UserRepository {
    private final UserDao userDao;
    private final UserDoConverter converter;

    public User save(User user) {
        UserDO userDO = converter.model2Do(user);
        BaseDO.init(userDO);

        return converter.do2Model(this.userDao.save(userDO));
    }

    public User findById(Long userId) {
        Specification<UserDO> specification = Specification.where((Specification<UserDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.<Long>get("id"), userId));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });

        UserDO userDO = this.userDao.findOne(specification).orElse(null);
        return this.converter.do2Model(userDO);
    }

    public User findByPhoneAndPass(String phone, String password) {

        Specification<UserDO> specification = Specification.where((Specification<UserDO>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.<Integer>get("phone"), phone));
            list.add(cb.equal(root.<Integer>get("password"), password));
            return cq.where(list.toArray(new Predicate[0])).getRestriction();
        });


        Optional<UserDO> one = userDao.findOne(specification);
        return converter.do2Model(one.orElse(null));
    }
}
