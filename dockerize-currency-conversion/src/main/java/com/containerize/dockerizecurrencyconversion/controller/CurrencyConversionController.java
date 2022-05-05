package com.containerize.dockerizecurrencyconversion.controller;

import com.containerize.dockerizecurrencyconversion.model.CurrencyConversionResponse;
import com.containerize.dockerizecurrencyconversion.service.CurrencyExchangeFeignClient;
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
    private CurrencyExchangeFeignClient currencyExchangeFeignClient;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse convertCurrency(@PathVariable String from, @PathVariable String to,
                                                      @PathVariable BigDecimal quantity) {

        log.info("Received Request to convert from {} {} to {}. ", quantity, from, to);

        CurrencyConversionResponse response = currencyExchangeFeignClient.retrieveExchangeValue(from, to);

        BigDecimal convertedValue = quantity.multiply(response.getConversionMultiple());

        return new CurrencyConversionResponse(response.getId(), from, to, response.getConversionMultiple(), quantity, convertedValue);
    }

}
