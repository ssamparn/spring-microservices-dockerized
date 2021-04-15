package com.containerize.springappdockerize.repository;

import com.containerize.springappdockerize.entity.ApplianceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepository extends JpaRepository<ApplianceEntity, Integer> {

}
