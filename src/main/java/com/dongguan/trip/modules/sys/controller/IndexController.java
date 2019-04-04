package com.dongguan.trip.modules.sys.controller;

import com.dongguan.trip.modules.buz.entity.NavEntity;
import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import com.dongguan.trip.modules.buz.entity.TripFirstTypeEntity;
import com.dongguan.trip.modules.buz.service.NavService;
import com.dongguan.trip.modules.buz.service.TripDetailService;
import com.dongguan.trip.modules.buz.service.TripFirstTypeService;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import com.dongguan.trip.modules.sys.entity.TgEntity;
import com.dongguan.trip.modules.sys.service.TgService;
import com.dongguan.trip.modules.sys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private TgService tgService;
    @Resource
    private TripFirstTypeService tripFirstTypeService;
    @Resource
    private TripDetailService tripDetailService;
    @Resource
    private NavService navService;
    @Resource
    private UserService userService;

    @RequestMapping(value = {"/","/index.html","/index"})
    public ModelAndView  index(HttpServletRequest request, ModelAndView mav,@RequestParam(required = false) Long userId){
        SysUserEntity userEntity=null;
        if(userId!=null){
            userEntity = userService.findById(userId);
        }
        mav.setViewName("index");
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        List<TgEntity> tgEntities = tgService.listFirst4Tg();
        for (TgEntity tgEntity:tgEntities) {
            String filePath = tgEntity.getFilePath();
            File file=new File(filePath);
            String name = file.getName();
            tgEntity.setFilePath(basePath+"/file/image.html?file_name="+name);
        }
        TripFirstTypeEntity tripFirstTypeEntity=new TripFirstTypeEntity();
        tripFirstTypeEntity.setType(0);
        List<TripFirstTypeEntity> tripTypes = tripFirstTypeService.findAll(tripFirstTypeEntity);
        TripDetailEntity tripDetailEntity0=new TripDetailEntity();
        tripDetailEntity0.setBelong(Integer.parseInt(request.getParameter("belong")==null?"1":request.getParameter("belong")));
        List<TripDetailEntity> detailEntities = tripDetailService.findAll(tripDetailEntity0);
        for (TripDetailEntity tripDetailEntity:detailEntities) {
            String fileDetail = tripDetailEntity.getFileDetail();
            File file=new File(fileDetail);
            String name = file.getName();
            tripDetailEntity.setFileDetail(basePath+"/file/image.html?file_name="+name);
        }
        tripFirstTypeEntity.setType(1);
        List<TripFirstTypeEntity> tripTypesLeft = tripFirstTypeService.findAll(tripFirstTypeEntity);

        List<NavEntity> navEntities = navService.queryAll();
        mav.addObject("navEntities",navEntities);
        mav.addObject("tripTypes",tripTypes);
        mav.addObject("tgs",tgEntities);
        mav.addObject("tripDetails",detailEntities);
        mav.addObject("tripTypesLeft",tripTypesLeft);
        mav.addObject("user",userEntity);
        return mav;
    }
}
