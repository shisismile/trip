package com.dongguan.trip.modules.buz.controller;

import com.dongguan.trip.common.utils.R;
import com.dongguan.trip.common.utils.SnowFlake;
import com.dongguan.trip.modules.buz.entity.CartEntity;
import com.dongguan.trip.modules.buz.entity.CommentEntity;
import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import com.dongguan.trip.modules.buz.service.CartService;
import com.dongguan.trip.modules.buz.service.CommentService;
import com.dongguan.trip.modules.buz.service.TripDetailService;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Resource
    private CartService cartService;
    @Resource
    private TripDetailService tripDetailService;
    @Resource
    private CommentService commentService;

    @PostMapping("save.html")
    public R save(@RequestParam("cartId") Long cartId, @RequestParam("comment") String comment) {
        try {
            CartEntity cartEntity = cartService.findById(cartId);
            TripDetailEntity tripDetailEntity = cartEntity.getTripDetailEntity();
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setId(new SnowFlake().nextId());
            commentEntity.setComment(comment);
            commentEntity.setCreateTime(new Date());
            commentEntity.setSysUserEntity(cartEntity.getSysUserEntity());
            commentEntity.setTripDetailEntity(tripDetailEntity);
            commentService.save(commentEntity);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }
}
