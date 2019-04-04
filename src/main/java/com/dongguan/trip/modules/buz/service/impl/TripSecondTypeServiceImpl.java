package com.dongguan.trip.modules.buz.service.impl;

import com.dongguan.trip.modules.buz.entity.TripSecondTypeEntity;
import com.dongguan.trip.modules.buz.repository.TripSecondTypeRepository;
import com.dongguan.trip.modules.buz.service.TripSecondTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TripSecondTypeServiceImpl implements TripSecondTypeService {

    @Resource
    private TripSecondTypeRepository tripSecondTypeRepository;

    @Override
    public void save(TripSecondTypeEntity tripSecondTypeEntity) {
        tripSecondTypeRepository.save(tripSecondTypeEntity);
    }
}
