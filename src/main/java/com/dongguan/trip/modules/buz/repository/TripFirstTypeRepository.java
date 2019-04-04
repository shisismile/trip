package com.dongguan.trip.modules.buz.repository;

import com.dongguan.trip.modules.buz.entity.TripFirstTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TripFirstTypeRepository extends JpaRepository<TripFirstTypeEntity, Long>,JpaSpecificationExecutor<TripFirstTypeEntity> {
}
