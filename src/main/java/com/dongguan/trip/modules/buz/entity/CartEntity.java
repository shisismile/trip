package com.dongguan.trip.modules.buz.entity;

import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "trip_cart")
@Setter
@Getter
public class CartEntity implements Serializable {
    @Id
    private Long id;
    @Column(length = 255)
    private String number;
    @Column(length = 255)
    private String picUrl; //购物车图片
    @ManyToOne(targetEntity = TripDetailEntity.class)
    @JoinColumn(name = "tripDetailId")
    private TripDetailEntity tripDetailEntity;//订单详细信息
    @ManyToOne(targetEntity = SysUserEntity.class)
    @JoinColumn(name = "useId")
    private SysUserEntity sysUserEntity;//订单对应的用户信息
    @Column
    private Date createTime;
    @Column(length = 4)
    private Integer status;//状态 0 为待交易 1 已完成交易 -1
}
