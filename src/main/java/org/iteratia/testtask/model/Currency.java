package org.iteratia.testtask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @Column(name = "id")
    private static int id = 1;

    @Column(name = "idCurrency")
    private String idCurrency;

    @Column(name = "numCode")
    private String numCode;

    @Column(name = "charCode")
    private String charCode;

    @Column(name = "nominal")
    private int nominal;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private double value;

    @Column(name = "date")
    private Date date;

    public Currency() {
        id++;
    }
//    public Currency(String id, String numCode, String charCode, int nominal, String name, double value, Date date) {
//        this.id = id;
//        this.numCode = numCode;
//        this.charCode = charCode;
//        this.nominal = nominal;
//        this.name = name;
//        this.value = value;
//        this.date = date;
//    }

    public int getId() {
        return id;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public void setIdCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int compareToDate(Currency anotherCurrency) {
        return this.date.compareTo(anotherCurrency.date);
    }
}
