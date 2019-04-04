package com.dongguan.trip.modules.buz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**************************************************************
 * @ClassName NavEntity
 * @Description 导航栏的信息
 * @Author smile
 * @Date 2019/2/20 13:38
 * @Version 1.0.0
 **************************************************************/
@Entity
@Table(name = "t_nav")
@Setter
@Getter
public class NavEntity {
    @Id
    private Long id;
    @Column(length = 255)
    private String href;
    @Column(length = 255)
    private String navName;

}
