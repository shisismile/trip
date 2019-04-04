package com.dongguan.trip.modules.sys.repository;

import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserEntityRepository extends JpaRepository<SysUserEntity, Long>,JpaSpecificationExecutor<SysUserEntity> {

    SysUserEntity findByUserId(Long userId);
}
