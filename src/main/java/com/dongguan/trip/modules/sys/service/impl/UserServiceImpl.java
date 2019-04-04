package com.dongguan.trip.modules.sys.service.impl;

import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import com.dongguan.trip.modules.sys.repository.SysUserEntityRepository;
import com.dongguan.trip.modules.sys.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserEntityRepository userEntityRepository;

    @Override
    public int save(SysUserEntity user) throws Exception {
        try {
            userEntityRepository.save(user);
            return 0;
        } catch (Exception e) {
           throw new Exception();
        }

    }

    @Override
    public Page<SysUserEntity> queryPage(SysUserEntity sysUserEntity, Integer startPage, Integer pageSize, Sort.Direction direction, String... properties) {
        Pageable pageable=PageRequest.of(startPage-1,pageSize,direction,properties);
        return userEntityRepository.findAll(new Specification<SysUserEntity>() {
            @Override
            public Predicate toPredicate(Root<SysUserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(sysUserEntity!=null&&sysUserEntity.getUsername()!=null){
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("username"),sysUserEntity.getUsername()));
                }
                return predicate;
            }
        }, pageable);
    }

    @Override
    public SysUserEntity findByUsername(String username) {
        List<SysUserEntity> sysUserEntities = userEntityRepository.findAll(new Specification<SysUserEntity>() {
            @Override
            public Predicate toPredicate(Root<SysUserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(username!=null&&!"".equals(username)){
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("username"),username));
                }
                return predicate;
            }
        });
        return sysUserEntities.size()>=0?sysUserEntities.get(0):null;
    }

    @Override
    public SysUserEntity findById(Long id) {
      return userEntityRepository.findByUserId(id);
    }

    @Override
    public void delete(Long uId) {
        userEntityRepository.deleteById(uId);
    }
}
