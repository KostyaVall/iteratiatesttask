package org.iteratia.testtask.service;

import org.iteratia.testtask.model.CurrencyConversion;
import org.iteratia.testtask.repository.CurrencyConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    @Override
    public List<CurrencyConversion> read(String numCodeFrom, String numCodeTo) {
        List<CurrencyConversion> currencyConversionList = currencyConversionRepository.findCurrencyConversionByCharCodeFromAndCharCodeTo(numCodeFrom, numCodeTo);
        Calendar calendar = new GregorianCalendar();
        Calendar newCalendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        newCalendar.add(Calendar.DAY_OF_MONTH, -7);
        Date date = newCalendar.getTime();
        List<CurrencyConversion> resultCurrencyConversionList = new ArrayList<>();
        for (CurrencyConversion a : currencyConversionList) {
            if (a.getDate().compareTo(date) >= 0) {
                resultCurrencyConversionList.add(a);
            }
        }

        return resultCurrencyConversionList;
    }

    @Override
    public void create(CurrencyConversion currencyConversion) {
        currencyConversionRepository.save(currencyConversion);
    }
}
