package com.dongguan.trip.modules.buz.repository;

import com.dongguan.trip.modules.buz.entity.NavEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**************************************************************
 * @InterfaceName NavEntityReposity
 * @Description 导航菜单dao
 * @Author smile
 * @Date 2019/2/20 13:40
 * @Version 1.0.0
 **************************************************************/
@Repository
public interface NavEntityRepository extends JpaRepository<NavEntity, Long>,JpaSpecificationExecutor<NavEntity> {
}
