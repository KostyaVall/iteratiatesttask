package org.iteratia.testtask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "currencyconversion")
public class CurrencyConversion {
    @Id
    @Column(name = "id")
    private Integer id;

    private static Integer idTmp = 0;

    @Column(name = "idcurrencyfrom")
    private String idCurrencyFrom;

    @Column(name = "numcodefrom")
    private String numCodeFrom;

    @Column(name = "charcodefrom")
    private String charCodeFrom;

    @Column(name = "nominalfrom")
    private int nominalFrom;

    @Column(name = "namefrom")
    private String nameFrom;

    @Column(name = "valuefrom")
    private double valueFrom;

    @Column(name = "idcurrencyto")
    private String idCurrencyTo;

    @Column(name = "numcodeto")
    private String numCodeTo;

    @Column(name = "charcodeto")
    private String charCodeTo;

    @Column(name = "nominalto")
    private int nominalTo;

    @Column(name = "nameto")
    private String nameTo;

    @Column(name = "valueto")
    private double valueTo;

    @Column(name = "conversiondate")
    private Date date;

    @Column(name = "conversionvalue")
    private Date conversionValue;

    public CurrencyConversion() {
        idTmp++;
        this.id = idTmp;
    }

    public Integer getId() {
        return id;
    }

    public String getIdCurrencyFrom() {
        return idCurrencyFrom;
    }

    public String getNumCodeFrom() {
        return numCodeFrom;
    }

    public String getCharCodeFrom() {
        return charCodeFrom;
    }

    public int getNominalFrom() {
        return nominalFrom;
    }

    public String getNameFrom() {
        return nameFrom;
    }

    public double getValueFrom() {
        return valueFrom;
    }

    public String getIdCurrencyTo() {
        return idCurrencyTo;
    }

    public String getNumCodeTo() {
        return numCodeTo;
    }

    public String getCharCodeTo() {
        return charCodeTo;
    }

    public int getNominalTo() {
        return nominalTo;
    }

    public String getNameTo() {
        return nameTo;
    }

    public double getValueTo() {
        return valueTo;
    }

    public Date getDate() {
        return date;
    }

    public Date getConversionValue() {
        return conversionValue;
    }

    public void setIdCurrencyFrom(String idCurrencyFrom) {
        this.idCurrencyFrom = idCurrencyFrom;
    }

    public void setNumCodeFrom(String numCodeFrom) {
        this.numCodeFrom = numCodeFrom;
    }

    public void setCharCodeFrom(String charCodeFrom) {
        this.charCodeFrom = charCodeFrom;
    }

    public void setNominalFrom(int nominalFrom) {
        this.nominalFrom = nominalFrom;
    }

    public void setNameFrom(String nameFrom) {
        this.nameFrom = nameFrom;
    }

    public void setValueFrom(double valueFrom) {
        this.valueFrom = valueFrom;
    }

    public void setIdCurrencyTo(String idCurrencyTo) {
        this.idCurrencyTo = idCurrencyTo;
    }

    public void setNumCodeTo(String numCodeTo) {
        this.numCodeTo = numCodeTo;
    }

    public void setCharCodeTo(String charCodeTo) {
        this.charCodeTo = charCodeTo;
    }

    public void setNominalTo(int nominalTo) {
        this.nominalTo = nominalTo;
    }

    public void setNameTo(String nameTo) {
        this.nameTo = nameTo;
    }

    public void setValueTo(double valueTo) {
        this.valueTo = valueTo;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setConversionValue(Date conversionValue) {
        this.conversionValue = conversionValue;
    }
}
