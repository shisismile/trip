package com.dongguan.trip.modules.sys.service;

import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface UserService {

    int save(SysUserEntity user) throws Exception;

    Page<SysUserEntity> queryPage(SysUserEntity sysUserEntity, Integer startPage, Integer pageSize, Sort.Direction direction, String... properties);

    SysUserEntity findByUsername(String username);

    SysUserEntity findById(Long id);

    void  delete(Long uId);
}
