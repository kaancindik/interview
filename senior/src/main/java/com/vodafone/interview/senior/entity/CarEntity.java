package com.vodafone.interview.senior.entity;

import com.vodafone.interview.senior.enumeration.CarTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "car")
@Getter
@Setter
public class CarEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String licensePlate;

    @Column
    private String carColor;

    @Column
    private CarTypeEnum carType;

    @ElementCollection
    public List<Integer> parkSlotList;
}
