package org.iteratia.testtask.repository;

import org.iteratia.testtask.model.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

//используется для сохранения и получения информации в/из базу данных
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Integer> {
    List<CurrencyConversion> findCurrencyConversionByCharCodeFromAndCharCodeTo (String charCodeFrom, String charCodeTo);
}
