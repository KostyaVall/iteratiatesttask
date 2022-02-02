package org.iteratia.testtask.service;

import org.iteratia.testtask.model.Currency;

import java.util.Date;
import java.util.List;

public interface CurrencyService {

    Currency read(Date date, String numCode);

    List<String> read(Date date, boolean initVariables);

    void create(Currency currency);
}
