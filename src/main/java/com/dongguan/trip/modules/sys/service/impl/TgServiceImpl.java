package com.dongguan.trip.modules.sys.service.impl;

import com.dongguan.trip.modules.sys.entity.TgEntity;
import com.dongguan.trip.modules.sys.repository.TgEntityRepository;
import com.dongguan.trip.modules.sys.service.TgService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TgServiceImpl implements TgService {

    @Resource
    private TgEntityRepository tgEntityRepository;

    @Override
    public List<TgEntity> listFirst4Tg() {
        return tgEntityRepository.findAllWithCondition(1);
    }
}
