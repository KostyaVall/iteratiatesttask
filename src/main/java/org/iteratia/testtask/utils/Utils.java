package org.iteratia.testtask.utils;

import org.iteratia.testtask.model.Currency;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Utils {

    public static List<Currency> getCurrency() {

        List<Currency> currencies = new ArrayList<>();

        try {
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateFormat = simpleDateFormat.format(calendar.getTime());

            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + dateFormat);
            InputStream inputStream = url.openStream();
            InputStreamReader input = new InputStreamReader(inputStream, "windows-1251");
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

            currencies = AdvancedXMLHandler.getCurrencies();

            inputStream.close();
            input.close();
            bufferedReader.close();

//        for (Currency currency : currencies) {
//            System.out.println("Currency: " + currency.getDate() + " " + currency.getId() + " " + currency.getNumCode() + " "
//                    + currency.getCharCode() + " " + currency.getNominal() + " " + currency.getName() + " " + currency.getValue());
//        }
        } catch (IOException| SAXException|ParserConfigurationException e) {
            e.printStackTrace();
        }
        return currencies;
    }
}
