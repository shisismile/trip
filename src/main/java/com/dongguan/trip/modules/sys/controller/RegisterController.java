package com.dongguan.trip.modules.sys.controller;

import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.common.utils.SnowFlake;
import com.dongguan.trip.modules.buz.entity.NavEntity;
import com.dongguan.trip.modules.buz.service.NavService;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import com.dongguan.trip.modules.sys.service.UserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private UserService userService;
    @Resource
    private NavService navService;
    @RequestMapping("register.html")
    public ModelAndView toRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("regist");
        List<NavEntity> navEntities = navService.queryAll();
        modelAndView.addObject("navEntities",navEntities);
        return modelAndView;
    }

    @PostMapping("doRegister.html")
    @ResponseBody
    public R register(SysUserEntity sysUserEntity) {
        try {
            sysUserEntity.setSalt(UUID.randomUUID().toString());
            SimpleHash md5 = new SimpleHash("MD5", sysUserEntity.getPassword(), sysUserEntity.getSalt(), 1024);
            sysUserEntity.setPassword(md5.toString());
            sysUserEntity.setCreateTime(new Date());
            sysUserEntity.setStatus(0);
            sysUserEntity.setUserId(new SnowFlake().nextId());
            userService.save(sysUserEntity);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("用户名已存在！");
        }
    }
}
