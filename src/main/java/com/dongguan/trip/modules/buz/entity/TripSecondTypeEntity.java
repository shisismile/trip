package com.dongguan.trip.modules.buz.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trip_sencod_type")
@Setter
@Getter
public class TripSecondTypeEntity {

    @Id
    private Long id;

    @Column(length = 255)
    private String href;

    @Column(length = 255)
    private String typeName;

    @ManyToOne(targetEntity = TripFirstTypeEntity.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "tripFirstTypeId")
    private TripFirstTypeEntity tripFirstTypeEntity;

}
