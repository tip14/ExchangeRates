package gq.exchangerates.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexey on 07.01.2018.
 */
@Service
public class Utils {

    private final String API_URL = "https://api.fixer.io/";
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private List<Map<String, Object>> apiResponsesCache = new ArrayList<Map<String, Object>>();
    private String cacheDate = "";


    public String buildRequestUrl(String baseCurrency, String date, String... currencySymbols) {
        StringBuilder request = new StringBuilder();
        request.append(API_URL);
        request.append(date);
        request.append("?base=");
        request.append(baseCurrency);
        request.append("&symbols=");
        for (String symbol : currencySymbols) {
            request.append(symbol + ",");
        }
        request.deleteCharAt(request.length() - 1);

        return request.toString();
    }

    public String[] getLastTenDays() throws IOException {
        String[] tenDates = new String[10];
        for (int i = 0; i < 10; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -i);
            tenDates[i] = dateFormat.format(calendar.getTime());
        }
        return tenDates;
    }

    public List<Map<String, Object>> getRatesForLastTenDays(String baseCurrency) throws IOException {
        apiResponsesCache.clear();
        if (useCache()){
            return apiResponsesCache;
        } else {
            apiResponsesCache.clear();
            RestTemplate restTemplate = new RestTemplate();
            String[] lastTenDays = getLastTenDays();
            for (String date : lastTenDays) {
                String request = buildRequestUrl(baseCurrency, date, ResourcesReader.readCurrencies());
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(request, String.class);
                Map<String, Object> jsonToMap = new ObjectMapper().readValue(responseEntity.getBody(), Map.class);
                apiResponsesCache.add(jsonToMap);
            }

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 0);
            cacheDate = dateFormat.format(calendar.getTime());

            return apiResponsesCache;
        }

    }

    private boolean useCache(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0);
        String currentDate = dateFormat.format(calendar.getTime());

        if (apiResponsesCache.isEmpty() || !cacheDate.equals(currentDate)) {
            return false;
        }
        return true;
    }
}
