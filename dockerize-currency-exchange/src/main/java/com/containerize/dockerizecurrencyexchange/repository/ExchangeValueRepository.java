package com.containerize.dockerizecurrencyexchange.repository;

import com.containerize.dockerizecurrencyexchange.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
