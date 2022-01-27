package org.iteratia.testtask.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iteratia.testtask.model.Currency;
import org.iteratia.testtask.service.CurrencyService;
import org.iteratia.testtask.service.CurrencyServiceImpl;
import org.iteratia.testtask.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping(value = "/{currency}")
    public ResponseEntity<String> read(@PathVariable(name = "currency") String idCurrency) throws JsonProcessingException {
        final Currency currency = currencyService.read(new Date(2022, Calendar.JANUARY, 27), idCurrency);

        ObjectMapper mapper = new ObjectMapper();

        return currency != null
                ? new ResponseEntity<>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(currency), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
