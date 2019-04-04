package com.dongguan.trip.modules.common;

import com.dongguan.trip.common.utils.ImageCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/code")
public class CodeController {
    /*
     * @Resource默认按 byName 自动注入,是J2EE提供的， 需导入Package: javax.annotation.Resource;
     *
     * @Resource有两个中重要的属性：name和type ，而Spring将@Resource注解的name属性解析为bean的
     * 名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用 type属性时则使用
     * byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用by Name自动注入策略。
     */
    @Resource
    ImageCode imageCode;

    private static String sRand;

    @RequestMapping(value = "/openLoginPage")
    public String openLoginPage(HttpServletRequest request, HttpServletResponse response) {
        String msg=request.getParameter("msg");
        if(msg==null&& msg.isEmpty()){
            //得到用户读入框信息，如果没有输入或者为空，直接跳转到验证失败页面
            return "error";
        }else{
            if(sRand.equalsIgnoreCase((msg))){
                //得到用户输入的验证码匹配成功，跳转到验证通过页面
                return "ok";
            }else{
                //得到用户输入的验证码匹配失败，跳转到验证失败页面
                return "error";
            }
        }
    }

    @RequestMapping(value = "/getImage.html")
    public void getImage(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        // 禁止图片缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到servlet输出流中
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(imageCode.getImage(request), "jpeg", sos);
        sos.close();
        sRand=(String)request.getAttribute("sRand");
        String result="ok";
    }
}
