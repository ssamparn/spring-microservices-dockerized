package com.containerize.springappdockerize.web.controller;

import com.containerize.springappdockerize.entity.ApplianceEntity;
import com.containerize.springappdockerize.model.Appliance;
import com.containerize.springappdockerize.service.ApplianceResponseFactory;
import com.containerize.springappdockerize.service.ApplianceService;
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

    @PostMapping("/post")
    public ResponseEntity<Appliance> createAppliance(@RequestBody Appliance appliance) {

        final ApplianceEntity entity = applianceService.createAppliance(appliance);
        final Appliance response = applianceResponseFactory.createApplianceResponse(entity);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Appliance>> getAllAppliances() {

        final List<ApplianceEntity> appliances = applianceService.getAppliances();
        final List<Appliance> response = applianceResponseFactory.createGetAppliancesResponse(appliances);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
