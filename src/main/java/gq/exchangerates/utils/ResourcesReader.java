package gq.exchangerates.utils;

import java.util.ResourceBundle;

public class ResourcesReader {

    public static String[] readCurrencies(){
        ResourceBundle bundle = ResourceBundle.getBundle("currencies");
        String[] currenciesList = bundle.getString("currencies.list").replaceAll(" ", "").split(",");

        return currenciesList;
    }
}
