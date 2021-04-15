package com.containerize.springappdockerize.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name="HOUSEHOLD_APPLIANCES")
public class ApplianceEntity {

    @Id
    @Column(name = "SERIAL_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serialnumber;

    @Column(name="BRAND_NAME")
    private String brand;

    @Column(name="MODEL_NAME")
    private String model;

    @Column(name="STATUS_NAME")
    private String status;

    @Column(name="DATE")
    private LocalDate date;

}
