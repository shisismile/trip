package com.dongguan.trip.modules.buz.service.impl;

import com.dongguan.trip.modules.buz.entity.TripFirstTypeEntity;
import com.dongguan.trip.modules.buz.repository.TripFirstTypeRepository;
import com.dongguan.trip.modules.buz.service.TripFirstTypeService;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class TripFirstTypeServiceImpl implements TripFirstTypeService {

    @Resource
    private TripFirstTypeRepository tripFirstTypeRepository;
    @Override
    public List<TripFirstTypeEntity> findAll(TripFirstTypeEntity tripFirstTypeEntity) {
        return tripFirstTypeRepository.findAll(new Specification<TripFirstTypeEntity>() {
            @Override
            public Predicate toPredicate(Root<TripFirstTypeEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(tripFirstTypeEntity!=null&&tripFirstTypeEntity.getType()!=null){
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("type"),tripFirstTypeEntity.getType()));
                }
                return predicate;
            }
        });
    }

    @Override
    public TripFirstTypeEntity findById(Long id) {
        Optional<TripFirstTypeEntity> byId = tripFirstTypeRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }
}
