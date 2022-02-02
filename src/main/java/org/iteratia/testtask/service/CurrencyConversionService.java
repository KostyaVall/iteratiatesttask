package org.iteratia.testtask.service;

import org.iteratia.testtask.model.CurrencyConversion;

import java.util.List;

public interface CurrencyConversionService {

    List<CurrencyConversion> read(String numCodeFrom, String numCodeTo);

    void create(CurrencyConversion currencyConversion);
}
