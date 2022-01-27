package org.iteratia.testtask.service;

import org.iteratia.testtask.model.Currency;
import org.iteratia.testtask.repository.CurrencyRepository;
import org.iteratia.testtask.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Currency read(Date data, String idCurrency) {

        List<Currency> currencies = currencyRepository.findAll(); //currencyRepository.findCurrencyByDateAndIdCurrency(data, idCurrency);
        if (currencies.isEmpty()) {
            currencies = Utils.getCurrency();
            for(Currency currency : currencies) {
                create(currency);
            }
        }
        currencies.sort(Currency::compareToDate);
        return currencies.get(currencies.size() - 1);
    }

    @Override
    public void create(Currency currency) {
        currencyRepository.save(currency);
    }
}
