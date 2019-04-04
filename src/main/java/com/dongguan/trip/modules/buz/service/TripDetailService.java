package com.dongguan.trip.modules.buz.service;

import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface TripDetailService {

    Page<TripDetailEntity> findWithPage(TripDetailEntity tripDetailEntity,Integer startPage, Integer pageSize, Sort.Direction direction, String... properties);

    List<TripDetailEntity> findAll(TripDetailEntity tripDetailEntity);

    TripDetailEntity findById(Long id);

    int save(TripDetailEntity tripDetailEntity);

    List<TripDetailEntity> findAllByUserId(Long uId);

}
