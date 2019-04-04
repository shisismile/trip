package com.dongguan.trip.modules.buz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buz_advertise")
@Setter
@Getter
public class AdvertiseEntity {
    @Id
    private Long id;
    @Column(length = 255)
    private String name;
    @Column(length = 2000)
    private String info;
    @Column(length = 255)
    private String filePath;
}
