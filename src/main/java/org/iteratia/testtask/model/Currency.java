package org.iteratia.testtask.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @Column(name = "id")
    private Integer id;

    private static Integer idTmp = 0;

    @Column(name = "idcurrency")
    private String idCurrency;

    @Column(name = "numcode")
    private String numCode;

    @Column(name = "charcode")
    private String charCode;

    @Column(name = "nominal")
    private int nominal;

    @Column(name = "name")
    private String name;

    @Column(name = "valuecurrency")
    private double value;

    @Column(name = "datecurrency")
    private Date date;

    public Currency() {
        idTmp++;
        this.id = idTmp;
    }

    public int getId() {
        return id;
    }

    public String getIdCurrency() {
        return idCurrency;
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
