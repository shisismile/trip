package com.dongguan.trip.modules.buz.controller;
import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import com.dongguan.trip.modules.sys.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**************************************************************
 * @ClassName RestController
 * @Description TODO
 * @Author smile
 * @Date 2019/3/30 10:47
 * @Version 1.0.0
 **************************************************************/
@RestController
public class RestPasswordController {

    @Resource
    private UserService userService;

    @GetMapping("/rest/{username}/{password}")
    public R restPassword(@PathVariable("username")String username,@PathVariable("password")String password)  {
        try{
        SysUserEntity user = userService.findByUsername(username);
        SimpleHash hash=new SimpleHash("MD5",password,user.getSalt(),1024);
        user.setPassword(hash.toString());
        userService.save(user);
        return R.ok();
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

    }
}
