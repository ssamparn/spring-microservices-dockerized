package com.containerize.web.appliance.controller;

import com.containerize.web.appliance.entity.ApplianceEntity;
import com.containerize.web.appliance.model.Appliance;
import com.containerize.web.appliance.service.ApplianceResponseFactory;
import com.containerize.web.appliance.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appliances")
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    @Autowired
    private ApplianceResponseFactory applianceResponseFactory;

    @PostMapping("/post-appliance")
    public ResponseEntity<Appliance> createAppliance(@RequestBody Appliance appliance) {

        final ApplianceEntity entity = applianceService.createAppliance(appliance);
        final Appliance response = applianceResponseFactory.createApplianceResponse(entity);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all-appliances")
    public ResponseEntity<List<Appliance>> getAllAppliances() {

        final List<ApplianceEntity> appliances = applianceService.getAppliances();
        final List<Appliance> response = applianceResponseFactory.createGetAppliancesResponse(appliances);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
