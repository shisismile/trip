package com.dongguan.trip.modules.sys.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_tg")
@Setter
@Getter
public class TgEntity {
    @Id
    private Long id;
    /**
     * 推广标题
     */
    @Column(length = 255)
    private String tgName;
    /**
     * 推广具体信息
     */
    @Column(length = 500)
    private String info;
    /**
     * 推广图片路径
     */
    @Column(length = 255)
    private String filePath;
    @Column(length = 4)
    private Integer active;
}
