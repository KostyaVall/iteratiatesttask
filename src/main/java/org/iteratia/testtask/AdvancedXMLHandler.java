package org.iteratia.testtask;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AdvancedXMLHandler extends DefaultHandler {
    private String id;
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;
    private String lastElementName;
    private Date date;
    private static List<Currency> currencies = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementName = qName;
        if (qName.equals("ValCurs")) {
            if (attributes != null) {
                String strDate = attributes.getValue(0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy", Locale.forLanguageTag("russia"));
                try {
                    date = simpleDateFormat.parse(strDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        if (qName.equals("Valute")) {
            if (attributes != null) {
                id = attributes.getValue(0);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String information = new String(ch, start, length);

        information = information.replace("\n", "").trim();

        if (!information.isEmpty()) {
            if (lastElementName.equals("NumCode")) {
                numCode = information;
            }

            if (lastElementName.equals("CharCode")) {
                charCode = information;
            }

            if (lastElementName.equals("Nominal")) {
                nominal = Integer.valueOf(information);
            }

            if (lastElementName.equals("Name")) {
                name = information;
            }

            if (lastElementName.equals("Value")) {
                value = Double.valueOf(information.replace(',','.'));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (    (numCode != null && !numCode.isEmpty())
                && (charCode != null && !charCode.isEmpty())
                && (nominal > 0)
                && (name != null && !name.isEmpty())
                && (value > 0)) {
            currencies.add(new Currency(id, numCode, charCode, nominal, name, value, date));
            id = null;
            numCode = null;
            charCode = null;
            nominal = 0;
            name = null;
            value = 0;
        }
    }

    public static List<Currency> getCurrencies() {
        return currencies;
    }
}

