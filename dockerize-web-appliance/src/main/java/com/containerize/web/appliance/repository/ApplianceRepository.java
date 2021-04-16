package com.containerize.web.appliance.repository;

import com.containerize.web.appliance.entity.ApplianceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepository extends JpaRepository<ApplianceEntity, Integer> {

}
