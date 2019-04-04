package com.dongguan.trip.modules.sys.controller;

import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import com.dongguan.trip.modules.sys.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("login.html")
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("login");
        return mav;
    }

    @PostMapping("doLogin.html")
    @ResponseBody
    public R doLogin(SysUserEntity sysUserEntity, HttpSession session) {
        try {
            SysUserEntity byUsername = userService.findByUsername(sysUserEntity.getUsername());
            if (byUsername==null){
                return R.error("用户不存在！");
            }else{
                SimpleHash md5 = new SimpleHash("MD5", sysUserEntity.getPassword(), byUsername.getSalt(), 1024);
                if(byUsername.getPassword().equalsIgnoreCase(md5.toString())){
                    session.setAttribute("CURRENT_USER",byUsername);
                    return R.ok(new HashMap<String, Object>(){{put("user",byUsername);}});
                }else {
                    return R.error("用户名或者密码错误！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @GetMapping("loginout.html")
    public String logout(HttpSession session){
        session.removeAttribute("CURRENT_USER");
        return "redirect:/";
    }
}
