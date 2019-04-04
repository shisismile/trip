package com.dongguan.trip.modules.buz.controller;

import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.common.utils.SnowFlake;
import com.dongguan.trip.modules.buz.entity.NavEntity;
import com.dongguan.trip.modules.buz.service.NavService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**************************************************************
 * @ClassName NavEntityController
 * @Description 导航菜单的web接口
 * @Author smile
 * @Date 2019/2/20 13:46
 * @Version 1.0.0
 **************************************************************/
@RestController
@RequestMapping("nav")
public class NavEntityController {

    @Resource
    private NavService navService;
    @Resource
    private SnowFlake flake;

    @RequestMapping("allNav.html")
    public List<NavEntity> findAll() {
        return navService.queryAll();
    }

    @RequestMapping("save.html")
    public R save(NavEntity navEntity) {
        try {
            if(navEntity.getId()==null||navEntity.getId()==0){
                navEntity.setId(flake.nextId());
            }
            navService.save(navEntity);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }

}
