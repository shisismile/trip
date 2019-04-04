package com.dongguan.trip.modules.sys.controller;

import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.modules.buz.entity.CartEntity;
import com.dongguan.trip.modules.buz.entity.NavEntity;
import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import com.dongguan.trip.modules.buz.service.CartService;
import com.dongguan.trip.modules.buz.service.NavService;
import com.dongguan.trip.modules.buz.service.TripDetailService;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import com.dongguan.trip.modules.sys.service.UserService;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private TripDetailService tripDetailService;
    @Resource
    private NavService navService;
    @Resource
    private CartService cartService;

    @RequestMapping("userDetail.html")
    public ModelAndView userDetail(ModelAndView mav, HttpServletRequest request, HttpSession session) {
        SysUserEntity userEntity = (SysUserEntity) session.getAttribute("CURRENT_USER");
        if (userEntity != null) {
            List<CartEntity> allByUser = cartService.findAllByUser(userEntity.getUserId());
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
            for (CartEntity cartEntity1 : allByUser) {
                String picUrl = cartEntity1.getPicUrl();
                if (picUrl != null) {
                    File pic = new File(picUrl);
                    cartEntity1.setPicUrl(basePath + "/file/image.html?file_name=" + pic.getName());
                }
            }
            List<TripDetailEntity> allByUserId = tripDetailService.findAllByUserId(userEntity.getUserId());
            for (TripDetailEntity tripDetailEntity : allByUserId) {
                if (!StringUtils.isEmpty(tripDetailEntity.getFileDetail())) {
                    File fileDetail_ = new File(tripDetailEntity.getFileDetail());
                    tripDetailEntity.setFileDetail(basePath + "/file/image.html?file_name=" + fileDetail_.getName());
                }

                String fileDetail0 = tripDetailEntity.getFileDetail0();
                if (!StringUtils.isEmpty(fileDetail0)) {
                    File fileDetail0_ = new File(fileDetail0);
                    tripDetailEntity.setFileDetail0(basePath + "/file/image.html?file_name=" + fileDetail0_.getName());
                }
                String fileDetail1 = tripDetailEntity.getFileDetail1();
                if (!StringUtils.isEmpty(fileDetail1)) {
                    File fileDetail1_ = new File(fileDetail1);
                    tripDetailEntity.setFileDetail1(basePath + "/file/image.html?file_name=" + fileDetail1_.getName());
                }
                String fileDetail2 = tripDetailEntity.getFileDetail2();
                if (!StringUtils.isEmpty(fileDetail2)) {
                    File fileDetail2_ = new File(fileDetail2);
                    tripDetailEntity.setFileDetail2(basePath + "/file/image.html?file_name=" + fileDetail2_.getName());
                }
            }
            List<NavEntity> navEntities = navService.queryAll();
            mav.addObject("navEntities", navEntities);
            mav.addObject("tripDetails", allByUserId);
            mav.addObject("allByUserCart", allByUser);
            mav.setViewName("user");
        } else {
            mav.setViewName("redirect:/index.html");
        }
        return mav;
    }

    @RequestMapping("save.html")
    public @ResponseBody
    R save(SysUserEntity sysUserEntity) {
        try {
            SysUserEntity userEntity = userService.findById(sysUserEntity.getUserId());
            SimpleHash md5 = new SimpleHash("MD5", sysUserEntity.getPassword(), userEntity.getSalt(), 1024);
            sysUserEntity.setPassword(md5.toString());
            userEntity.setUpdateTime(new Date());
            userEntity.setIdCode(sysUserEntity.getIdCode());
            userEntity.setPassword(sysUserEntity.getPassword());
            userEntity.setGender(sysUserEntity.getGender());
            userEntity.setMobile(sysUserEntity.getMobile());
            userEntity.setTrueName(sysUserEntity.getTrueName());
            userService.save(userEntity);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @RequestMapping("getWithPage.html")
    public @ResponseBody R findPage(SysUserEntity sysUserEntity,Integer page,Integer rows){
        Page<SysUserEntity> entityPage = userService.queryPage(sysUserEntity, page, rows, Sort.Direction.ASC, "userId");
        R result = R.ok().put("total",entityPage.getTotalElements() ).put("rows",entityPage.getContent() );
        return result;
    }
    @RequestMapping("delete.html")
    public @ResponseBody R delete(Long uId){
        try{userService.delete(uId);return R.ok();}catch (Exception e){return R.error();}
    }

}
