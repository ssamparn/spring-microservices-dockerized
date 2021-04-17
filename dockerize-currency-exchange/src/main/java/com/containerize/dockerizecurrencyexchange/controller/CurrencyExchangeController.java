package com.containerize.dockerizecurrencyexchange.controller;

import com.containerize.dockerizecurrencyexchange.entity.ExchangeValue;
import com.containerize.dockerizecurrencyexchange.repository.ExchangeValueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class CurrencyExchangeController {

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to,
                                               @RequestHeader Map<String, String> headers) {

        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

        log.info("{} {} {}", from, to, exchangeValue);

        if (exchangeValue == null) {
            throw new RuntimeException("Unable to find data to convert " + from + " to " + to);
        }

        return exchangeValue;
    }
}
