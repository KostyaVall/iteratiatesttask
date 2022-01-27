package org.iteratia.testtask;

import org.iteratia.testtask.model.Currency;
import org.iteratia.testtask.service.CurrencyServiceImpl;
import org.iteratia.testtask.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        List<Currency> currencies = Utils.getCurrency();
        CurrencyServiceImpl currencyService = new CurrencyServiceImpl();
        for(Currency currency : currencies) {
            currencyService.create(currency);
        }

        SpringApplication.run(Main.class, args);
    }
}
