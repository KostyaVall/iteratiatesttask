package org.iteratia.testtask.service;

import org.iteratia.testtask.model.Currency;
import org.iteratia.testtask.repository.CurrencyRepository;
import org.iteratia.testtask.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//сервис для работы валютой
@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Currency read(Date date, String charCode) {

        //получение валюты на заданную дату
        List<Currency> currencies = currencyRepository.findCurrencyByDateAndCharCode(date, charCode);
        if (currencies.isEmpty()) {
            currencies = Utils.getCurrency();
            for(Currency currency : currencies) {
                create(currency);
            }
        }
        currencies.stream().filter(x -> x.getCharCode().equals(charCode));
        currencies.sort(Currency::compareToDate);
        return currencies.get(currencies.size() - 1);
    }

    //получение списка символьных кодов валют для первоначального заполнения
    @Override
    public List<String> read(Date date, boolean initVariables) {

        List<Currency> currencies = new ArrayList<>(34);
        if(!initVariables) {
            currencies = currencyRepository.findCurrencyByDate(date);
        }
        if (currencies.isEmpty()) {
            currencies = Utils.getCurrency();
            for(Currency currency : currencies) {
                create(currency);
            }
        }
        List<String> charCodes = new ArrayList<>();

        for (Currency a : currencies) {
            charCodes.add(a.getCharCode());
        }
        charCodes.sort(String::compareTo);
        return charCodes;
    }

    //сохранение информации в БД
    @Override
    public void create(Currency currency) {
        currencyRepository.save(currency);
    }
}
