package com.containerize.web.appliance.service;

import com.containerize.web.appliance.entity.ApplianceEntity;
import com.containerize.web.appliance.model.Appliance;
import com.containerize.web.appliance.repository.ApplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplianceService {

    @Autowired
    private ApplianceRepository repository;

    public ApplianceEntity createAppliance(Appliance appliance) {
        ApplianceEntity applianceEntity = new ApplianceEntity();
        applianceEntity.setSerialnumber(appliance.getSerialnumber());
        applianceEntity.setBrand(appliance.getBrand());
        applianceEntity.setModel(appliance.getModel());
        applianceEntity.setStatus(appliance.getStatus());
        applianceEntity.setDate(appliance.getDate());

        return repository.save(applianceEntity);
    }

    public List<ApplianceEntity> getAppliances() {
        return repository.findAll();
    }
}
