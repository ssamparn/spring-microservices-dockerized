package com.containerize.dockerizecurrencyconversion.service;

import com.containerize.dockerizecurrencyconversion.model.CurrencyConversionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "${CURRENCY_EXCHANGE_URI:http://localhost:8000}")
//@FeignClient(name = "CURRENCY-EXCHANGE-SERVICE")
public interface CurrencyExchangeFeignClient {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionResponse retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
