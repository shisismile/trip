package com.dongguan.trip.modules.buz.service;

import com.dongguan.trip.modules.buz.entity.NavEntity;

import java.util.List;

/**************************************************************
 * @InterfaceName NavService
 * @Description 导航菜单的业务接口
 * @Author smile
 * @Date 2019/2/20 13:42
 * @Version 1.0.0
 **************************************************************/
public interface NavService {

    List<NavEntity> queryAll();

    void save(NavEntity navEntity);

}
