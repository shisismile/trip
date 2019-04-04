package com.dongguan.trip.modules.buz.service.impl;

import com.dongguan.trip.modules.buz.entity.NavEntity;
import com.dongguan.trip.modules.buz.repository.NavEntityRepository;
import com.dongguan.trip.modules.buz.service.NavService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**************************************************************
 * @ClassName NavServiceImpl
 * @Description 导航菜单业务的实现类
 * @Author smile
 * @Date 2019/2/20 13:44
 * @Version 1.0.0
 **************************************************************/
@Service("navService")
public class NavServiceImpl implements NavService {

    @Resource
    private NavEntityRepository navEntityRepository;

    @Override
    public List<NavEntity> queryAll() {
        return navEntityRepository.findAll(Sort.by("id"));
    }

    @Override
    public void save(NavEntity navEntity) {
        navEntityRepository.save(navEntity);
    }
}
