package org.iteratia.testtask;

import org.iteratia.testtask.AdvancedXMLHandler;
import org.iteratia.testtask.Currency;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
        InputStreamReader input = new InputStreamReader(url.openStream(), "windows-1251");
        BufferedReader bufferedReader = new BufferedReader(input);

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine());
        }
        String str = stringBuilder.toString();

        InputSource inputSource = new InputSource(new StringReader(str));
        inputSource.setEncoding(StandardCharsets.UTF_8.toString());

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        AdvancedXMLHandler handler = new AdvancedXMLHandler();
        parser.parse(inputSource, handler);

        List<Currency> currencies = AdvancedXMLHandler.getCurrencies();
        for (Currency currency : currencies) {
            System.out.println("Currency: " + currency.getDate() + " " + currency.getId() + " " + currency.getNumCode() + " "
                    + currency.getCharCode() + " " + currency.getNominal() + " " + currency.getName() + " " + currency.getValue());
        }
    }
}
