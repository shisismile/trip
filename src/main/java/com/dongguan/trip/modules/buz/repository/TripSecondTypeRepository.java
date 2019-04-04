package com.dongguan.trip.modules.buz.repository;

import com.dongguan.trip.modules.buz.entity.TripFirstTypeEntity;
import com.dongguan.trip.modules.buz.entity.TripSecondTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TripSecondTypeRepository extends JpaRepository<TripSecondTypeEntity, Long>,JpaSpecificationExecutor<TripSecondTypeEntity> {
}
