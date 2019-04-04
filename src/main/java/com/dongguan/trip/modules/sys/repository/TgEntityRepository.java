package com.dongguan.trip.modules.sys.repository;

import com.dongguan.trip.modules.sys.entity.TgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TgEntityRepository extends JpaRepository<TgEntity, Long>,JpaSpecificationExecutor<TgEntity> {

    @Query(value = "select * from sys_tg where active=?1 limit 0,4",nativeQuery = true)
    List<TgEntity> findAllWithCondition(Integer active);
}
