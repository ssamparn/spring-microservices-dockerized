package com.containerize.springappdockerize.service;

import com.containerize.springappdockerize.entity.ApplianceEntity;
import com.containerize.springappdockerize.model.Appliance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplianceResponseFactory {

    public List<Appliance> createGetAppliancesResponse(List<ApplianceEntity> appliances) {
        return appliances.stream()
                .map(entity -> Appliance.builder()
                        .serialnumber(entity.getSerialnumber())
                        .brand(entity.getBrand())
                        .model(entity.getModel())
                        .status(entity.getStatus())
                        .date(entity.getDate())
                        .build()
                    )
                .collect(Collectors.toList());
    }

    public Appliance createApplianceResponse(ApplianceEntity entity) {
        return Appliance.builder()
                .serialnumber(entity.getSerialnumber())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .status(entity.getStatus())
                .date(entity.getDate())
                .build();
    }
}
