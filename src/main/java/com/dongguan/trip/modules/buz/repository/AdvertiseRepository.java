package com.dongguan.trip.modules.buz.repository;

import com.dongguan.trip.modules.buz.entity.AdvertiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseRepository extends JpaRepository<AdvertiseEntity,Long> {
}
