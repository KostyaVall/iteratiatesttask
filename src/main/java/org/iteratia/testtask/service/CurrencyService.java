package org.iteratia.testtask.service;

import org.iteratia.testtask.model.Currency;

import java.util.Date;

public interface CurrencyService {

    Currency read(Date date, String numCode);

    void create(Currency currency);
}
