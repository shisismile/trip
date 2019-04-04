package com.dongguan.trip.modules.buz.entity;


import com.dongguan.trip.modules.buz.entity.TripDetailEntity;
import com.dongguan.trip.modules.sys.entity.SysUserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "trip_comment")
@Setter
@Getter
public class CommentEntity implements Serializable {

    @Id
    private Long id;

    @ManyToOne(targetEntity = SysUserEntity.class)
    @JoinColumn(name = "userId")
    private SysUserEntity sysUserEntity;

    @Column(length = 2000)
    private String comment;

    @Column

    private Date createTime;

    @Column(length = 4)
    private Integer status;


    @ManyToOne(targetEntity = TripDetailEntity.class,fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinColumn(name = "detailId")
    private TripDetailEntity tripDetailEntity;

}
