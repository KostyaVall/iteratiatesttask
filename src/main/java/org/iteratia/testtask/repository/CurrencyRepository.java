package org.iteratia.testtask.repository;

import org.iteratia.testtask.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    List<Currency> findCurrencyByDateAndIdCurrency (Date date, String idCurrency);
}
