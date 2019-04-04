package com.dongguan.trip.modules.buz.service.impl;

import com.dongguan.trip.modules.buz.entity.AdvertiseEntity;
import com.dongguan.trip.modules.buz.repository.AdvertiseRepository;
import com.dongguan.trip.modules.buz.service.AdvertiseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
    @Resource
    private AdvertiseRepository advertiseRepository;

    @Override
    public int save(AdvertiseEntity advertiseEntity) {
         return  advertiseRepository.save(advertiseEntity)==null?-1:0;
    }
}
