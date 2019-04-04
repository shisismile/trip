package com.dongguan.trip.modules.buz.entity;

import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trip_detail")
@Setter
@Getter
public class TripDetailEntity implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;
    /**
     * 标题
     */
    @Column(length = 255)
    private String title;
    /**
     * 实际价格
     */
    @Column(length = 10)
    private Integer realPrice;
    /**
     * 打折价格或者团购价
     */
    @Column(length = 10)
    private Integer countPrice;
    /**
     *最大优惠
     */
    @Column(length = 10)
    private Integer maxMinus;

    /**
     * 出游天数
     */
    @Column(length = 4)
    private Integer tripDays;

    /**
     * 出游人数
     */
    @Column(length = 10)
    private Integer triperNumber;

    /**
     *推荐理由
     */
    @Column(length = 2000)
    private String  recommended;
    /**
     * 优惠条目
     */
    @Column(length = 2000)
    private String discoutDetail;
    /**
     * 景点介绍
     */
    @Column(length = 2000)
    private String introductions;
    /**
     * 温馨提示
     */
    @Column(length = 2000)
    private String tips;
    /**
     * 是否打折 0 不打折 1 打折
     */
    @Column(length = 4)
    private Integer isOnCount;
    /**
     * 付款方式 0 即时付款 1 结束付款
     */
    @Column(length = 4)
    private Integer payWay=0;

    @Column(length = 255)
    private String shortName;//订单 简称
    /**
     * 图片路径
     */
    @Column(length = 500)
    private String fileDetail;

    @Column(length = 500)
    private String fileDetail0;

    @Column(length = 500)
    private String fileDetail1;

    @Column(length = 500)
    private String fileDetail2;

    @Column(length = 500)
    private String url;

    @Column(length = 4)
    private Integer status=0;

    @Column(length = 500)
    private String shortIntroductions;

    @Column(length = 4)
    private Integer belong;

    @ManyToOne(targetEntity = SysUserEntity.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private SysUserEntity sysUserEntity;

    @OneToMany(targetEntity = CommentEntity.class,fetch=FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "detailId")
    private Set<CommentEntity> commentEntitySet=new HashSet<>();
}
