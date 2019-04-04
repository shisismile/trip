package com.dongguan.trip.modules.buz.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trip_first_type")
@Setter
@Getter
public class TripFirstTypeEntity {

    @Id
    private Long id;
    @Column(length = 255)
    private String typeName;
    @Column(length = 255)
    private String cls;
    @Column(length = 4)
    private Integer type;

    @OneToMany(targetEntity = TripSecondTypeEntity.class)
    @JoinColumn(name = "tripFirstTypeId")
    private Set<TripSecondTypeEntity> secondTypeEntitySet=new HashSet<>();
}
