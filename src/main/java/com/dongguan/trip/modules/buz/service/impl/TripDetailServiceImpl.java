package com.dongguan.trip.modules.buz.service.impl;

import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import com.dongguan.trip.modules.buz.repository.TripDetailEntityRepository;
import com.dongguan.trip.modules.buz.service.TripDetailService;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TripDetailServiceImpl implements TripDetailService {
    @Resource
    private TripDetailEntityRepository tripDetail;

    @Override
    public Page<TripDetailEntity> findWithPage(TripDetailEntity tripDetailEntity,Integer startPage, Integer pageSize, Sort.Direction direction, String... properties) {
        Pageable pageable=PageRequest.of(startPage-1,pageSize,direction,properties);
        return tripDetail.findAll(new Specification<TripDetailEntity>() {
            @Override
            public Predicate toPredicate(Root<TripDetailEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate=criteriaBuilder.conjunction();
                if(tripDetailEntity!=null){
                    if(tripDetailEntity.getTitle()!=null){
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("title"),tripDetailEntity.getTitle()));
                    }
                }
                return predicate;
            }
        },pageable);
    }

    @Override
    public List<TripDetailEntity> findAll(TripDetailEntity tripDetailEntity) {
        return tripDetail.findAll(new Specification<TripDetailEntity>() {
            @Override
            public Predicate toPredicate(Root<TripDetailEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();

                if(tripDetailEntity!=null){
                    if(tripDetailEntity.getBelong()!=1){
                        predicate.getExpressions().add(criteriaBuilder.equal(root.get("belong"),tripDetailEntity.getBelong()));
                    }
                }
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("status"),0));
                return predicate;
            }
        });
    }

    @Override
    public TripDetailEntity findById(Long id) {
        List<TripDetailEntity> all = tripDetail.findAll(new Specification<TripDetailEntity>() {
            @Override
            public Predicate toPredicate(Root<TripDetailEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("id"),id));
                return predicate;
            }
        });
        return all!=null?all.get(0):null;
    }

    @Override
    public int save(TripDetailEntity tripDetailEntity) {
        return tripDetail.save(tripDetailEntity)==null?-1:0;
    }

    @Override
    public List<TripDetailEntity> findAllByUserId(Long uId) {
        return tripDetail.findAll(new Specification<TripDetailEntity>() {
            @Override
            public Predicate toPredicate(Root<TripDetailEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(uId!=null){
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("sysUserEntity").get("userId"),uId));
                }
                predicate.getExpressions().add(criteriaBuilder.equal(root.get("status"),0));
                return predicate;
            }
        });
    }


}
