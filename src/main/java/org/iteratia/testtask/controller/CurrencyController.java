package org.iteratia.testtask.controller;

import org.iteratia.testtask.model.Currency;
import org.iteratia.testtask.model.CurrencyConversion;
import org.iteratia.testtask.service.CurrencyConversionService;
import org.iteratia.testtask.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@Controller
public class CurrencyController {
    private final CurrencyService currencyService;

    private final CurrencyConversionService currencyConversionService;

    private List<String> charCodes = new ArrayList<>();

    @Autowired
    public CurrencyController(CurrencyService currencyService, CurrencyConversionService currencyConversionService) {
        this.currencyService = currencyService;
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/initVariables")
    public String initVariables(Model model) {

        Calendar calendar = new GregorianCalendar();
        charCodes = currencyService.read(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).getTime(), true);
        model.addAttribute("charCodes", charCodes);

        model.addAttribute("currencies", new ArrayList<CurrencyConversion>());
        model.addAttribute("sumValueTo", 0);
        model.addAttribute("sumValueToSum", 0);
        model.addAttribute("sumValueFromSum", 0);
        model.addAttribute("conversionValueAvg", 0);
        return "currency";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(@RequestParam(defaultValue = "") String currencyFrom, @RequestParam(defaultValue = "") String valueFrom, @RequestParam(defaultValue = "") String currencyTo, Model model) {

        try {
            Calendar calendar = new GregorianCalendar();
            Currency currencyCurrencyFrom = currencyService.read(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).getTime(), currencyFrom);
            Currency currencyCurrencyTo = currencyService.read(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).getTime(), currencyTo);

            double sumValueTo = currencyCurrencyFrom.getValue() * Double.valueOf(valueFrom) / currencyCurrencyFrom.getNominal() / currencyCurrencyTo.getValue() * currencyCurrencyTo.getNominal();
            double conversionValue = sumValueTo / Double.valueOf(valueFrom);

            CurrencyConversion currencyConversion = new CurrencyConversion();
            currencyConversion.setIdCurrencyFrom(currencyCurrencyFrom.getIdCurrency());
            currencyConversion.setNameFrom(currencyCurrencyFrom.getName());
            currencyConversion.setCharCodeFrom(currencyCurrencyFrom.getCharCode());
            currencyConversion.setNumCodeFrom(currencyCurrencyFrom.getNumCode());
            currencyConversion.setNominalFrom(currencyCurrencyFrom.getNominal());
            currencyConversion.setNameFrom(currencyCurrencyFrom.getName());
            currencyConversion.setValueFrom(currencyCurrencyFrom.getValue());
            currencyConversion.setDate(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).getTime());
            currencyConversion.setSumValueTo(sumValueTo);
            currencyConversion.setSumValueFrom(Double.valueOf(valueFrom));
            currencyConversion.setConversionValue(conversionValue);

            currencyConversion.setIdCurrencyTo(currencyCurrencyTo.getIdCurrency());
            currencyConversion.setNumCodeTo(currencyCurrencyTo.getNumCode());
            currencyConversion.setCharCodeTo(currencyCurrencyTo.getCharCode());
            currencyConversion.setNominalTo(currencyCurrencyTo.getNominal());
            currencyConversion.setNameTo(currencyCurrencyTo.getName());
            currencyConversion.setValueTo(currencyCurrencyTo.getValue());

            currencyConversionService.create(currencyConversion);
            List<CurrencyConversion> currencyConversionList = currencyConversionService.read(currencyFrom, currencyTo);

            double sumValueToSum = 0;
            double sumValueFromSum = 0;
            double conversionValueAvg = 0;

            for(CurrencyConversion a : currencyConversionList) {
                sumValueFromSum += a.getSumValueFrom();
                sumValueToSum += a.getSumValueTo();
                conversionValueAvg += a.getConversionValue();
            }
            conversionValueAvg = conversionValueAvg / currencyConversionList.size();

            model.addAttribute("sumValueToSum", sumValueToSum);
            model.addAttribute("sumValueFromSum", sumValueFromSum);
            model.addAttribute("conversionValueAvg", conversionValueAvg);

            model.addAttribute("sumValueTo", sumValueTo);
            model.addAttribute("currencies", currencyConversionList);
            model.addAttribute("charCodes", charCodes);
            return "currency";
        } catch (Exception e) {
            model.addAttribute("sumValueToSum", 0);
            model.addAttribute("sumValueFromSum", 0);
            model.addAttribute("conversionValueAvg", 0);

            model.addAttribute("sumValueTo", "Error specifying the value for currency conversion.");
            model.addAttribute("currencies", new ArrayList<CurrencyConversion>());
            model.addAttribute("charCodes", charCodes);

            e.printStackTrace();
            return "currency";
        }
    }
}
