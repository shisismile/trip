package com.dongguan.trip.modules.buz.repository;

import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDetailEntityRepository extends JpaRepository<TripDetailEntity, Long>,JpaSpecificationExecutor<TripDetailEntity> {
}
