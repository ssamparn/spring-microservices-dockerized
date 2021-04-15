package com.containerize.springappdockerize.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Appliance {
    private Integer serialnumber;
    private String brand;
    private String model;
    private String status;
    private LocalDate date;
}
