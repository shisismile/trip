package com.dongguan.trip.modules.buz.service;

import com.dongguan.trip.modules.buz.entity.TripFirstTypeEntity;

import java.util.List;

public interface TripFirstTypeService {

   List<TripFirstTypeEntity> findAll(TripFirstTypeEntity tripFirstTypeEntity);

   TripFirstTypeEntity findById(Long id);
}
