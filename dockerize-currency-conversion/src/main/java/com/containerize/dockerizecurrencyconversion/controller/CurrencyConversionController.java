package com.containerize.dockerizecurrencyconversion.controller;

import com.containerize.dockerizecurrencyconversion.model.CurrencyConversionBean;
import com.containerize.dockerizecurrencyconversion.service.CurrencyExchangeServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        log.info("Received Request to convert from {} {} to {}. ", quantity, from, to);

        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

        BigDecimal convertedValue = quantity.multiply(response.getConversionMultiple());

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, convertedValue);
    }

}
