package org.iteratia.testtask.repository;

import org.iteratia.testtask.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

//используется для сохранения и получения информации в/из базу данных
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    List<Currency> findCurrencyByDateAndCharCode (Date date, String charCode);

    List<Currency> findCurrencyByDate (Date date);
}
