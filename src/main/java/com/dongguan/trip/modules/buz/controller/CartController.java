package com.dongguan.trip.modules.buz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.common.utils.SnowFlake;
import com.dongguan.trip.modules.buz.entity.CartEntity;
import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import com.dongguan.trip.modules.buz.service.CartService;
import com.dongguan.trip.modules.buz.service.TripDetailService;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
public class CartController {

    @Resource
    private CartService cartService;
    @Resource
    private TripDetailService tripDetailService;

    @RequestMapping("cart.html")
    public ModelAndView toCart(HttpServletRequest request, ModelAndView mav,
                               @RequestParam(required = false, name = "page") Integer page,
                               @RequestParam(required = false, name = "pageSize") Integer pageSize,
                               CartEntity cartEntity) {
        cartEntity.setStatus(0);
        SysUserEntity userEntity = (SysUserEntity) request.getSession().getAttribute("CURRENT_USER");
        cartEntity.setSysUserEntity(userEntity);
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<CartEntity> page1 = cartService.queryPage(cartEntity, page, pageSize, Sort.Direction.ASC, "create_time");
        List<CartEntity> content = page1.getContent();
        for (CartEntity cartEntity1 : content) {
            String picUrl = cartEntity1.getPicUrl();
            if (picUrl != null) {
                File pic = new File(picUrl);
                cartEntity1.setPicUrl(basePath + "/file/image.html?file_name=" + pic.getName());
            }
        }
        mav.setViewName("cart");
        mav.addObject("list", content);
        mav.addObject("totle", page1.getTotalElements());
        mav.addObject("pages", page1.getTotalPages());
        return mav;
    }

    @RequestMapping("save.html")
    public ModelAndView save(ModelAndView mav, HttpServletRequest request, @RequestParam(required = false, name = "detailId") Long detailId,
                             @RequestParam(required = false, name = "status") Integer status) {
        if (status == null) {
            mav.setViewName("redirect:cart.html");
        } else {
            mav.setViewName("redirect:/");
        }
        TripDetailEntity detailServiceById = tripDetailService.findById(detailId);
        SysUserEntity userEntity = (SysUserEntity) request.getSession().getAttribute("CURRENT_USER");
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(new SnowFlake().nextId());
        cartEntity.setPicUrl(detailServiceById.getFileDetail());
        cartEntity.setCreateTime(new Date());
        cartEntity.setStatus(status == null ? 0 : status);
        cartEntity.setSysUserEntity(userEntity);
        cartEntity.setTripDetailEntity(detailServiceById);
        cartService.save(cartEntity);
        return mav;
    }

    @PostMapping("update.html")
    public @ResponseBody
    R update(@RequestParam("data") String data) {
        try {
            JSONArray objects = JSON.parseArray(data);
            for (int i = 0; i < objects.size(); i++) {
                long id = objects.getLongValue(i);
                CartEntity byId = cartService.findById(id);
                byId.setStatus(1);
                cartService.save(byId);
            }
            return R.ok("支付成功，将返回首页！");
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }

    }

    @RequestMapping("delete.html")
    public @ResponseBody
    R delete(@RequestParam("id") Long id) {
        try {
            cartService.delete(id);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }


    @RequestMapping("getWithPage.html")
    public @ResponseBody
    R getWithPage(CartEntity cartEntity, Integer page, Integer rows) {
        Page<CartEntity> entityPage = cartService.queryPage(cartEntity, page, rows, Sort.Direction.ASC, "id");
        List<CartEntity> content = entityPage.getContent();
        for (CartEntity cartEntity1 : content) {
            TripDetailEntity tripDetailEntity = cartEntity1.getTripDetailEntity();
            tripDetailEntity.setSysUserEntity(null);
            tripDetailEntity.setCommentEntitySet(null);
            cartEntity1.setTripDetailEntity(tripDetailEntity);
        }
        R result = R.ok().put("total", entityPage.getTotalElements()).put("rows", content);
        return result;
    }

}
