package org.iteratia.testtask.repository;

import org.iteratia.testtask.model.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Integer> {
    List<CurrencyConversion> findCurrencyConversionByNumCodeFromAndNumCodeToDateFromGreaterThan (Date dateFrom, String numCodeFrom, String numCodeTo);
}
