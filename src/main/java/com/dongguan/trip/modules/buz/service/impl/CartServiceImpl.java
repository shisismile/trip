package com.dongguan.trip.modules.buz.service.impl;

import com.dongguan.trip.modules.buz.entity.CartEntity;
import com.dongguan.trip.modules.buz.repository.CartEntityRepository;
import com.dongguan.trip.modules.buz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartEntityRepository cartEntityRepository;
    @Override
    public Page<CartEntity> queryPage(CartEntity cartEntity, Integer startPage, Integer pageSize, Sort.Direction direction, String... properties) {
        Pageable pageable=PageRequest.of(startPage-1,pageSize);
        Page<CartEntity> pages = cartEntityRepository.findAll(new Specification<CartEntity>() {
            @Override
            public Predicate toPredicate(Root<CartEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (cartEntity != null && cartEntity.getStatus() != null) {
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("status"), cartEntity.getStatus()));
                }
                if(cartEntity!=null&&cartEntity.getSysUserEntity()!=null&&cartEntity.getSysUserEntity().getUserId()!=null){
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("sysUserEntity").get("userId"), cartEntity.getSysUserEntity().getUserId()));
                }
                return predicate;
            }
        }, pageable);
        return pages;
    }

    @Override
    public void save(CartEntity cartEntity) {
        cartEntityRepository.save(cartEntity);
    }

    @Override
    public List<CartEntity> findAllById(Set<Long> ids) {
      return   cartEntityRepository.findAllById(ids);
    }

    @Override
    public CartEntity findById(Long id) {
        Optional<CartEntity> byId = cartEntityRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public List<CartEntity> findAllByUser(Long uid) {
        return cartEntityRepository.findAll(new Specification<CartEntity>() {
            @Override
            public Predicate toPredicate(Root<CartEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(uid!=null){
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("sysUserEntity").get("userId"),uid ));
                }
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("status"),1 ));
                return predicate;
            }
        });
    }

    @Override
    public void delete(Long id) throws Exception{

            cartEntityRepository.deleteById(id);

    }
}
