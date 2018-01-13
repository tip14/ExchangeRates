package gq.exchangerates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexey on 06.01.2018.
 */
@Controller
@RequestMapping("/")
public class RestController {
    //cache for requests
    //add config file (change config from admin page?)
    //database
    //logging
    //tests
    //log/register
    //bootstrap 4

   @Autowired
   private Utils utils;

//    @GetMapping("/login")
//    public String getLogin() {
//        return "login";
//    }
//
//    @GetMapping("/registration")
//    public String getRegistration() {
//        return "registration";
//    }

    @GetMapping
    public String getHome(){
        return "index";
    }

    @GetMapping(value = "/testpermit")
    public String permitAll(){
        return "testpermit";
    }

    @PostMapping(value = "/rates")
    public String changeCurrency(@ModelAttribute("chooseCurrency") String chooseCurrency){
        return "redirect:/rates/"+chooseCurrency.toLowerCase();
    }

    @GetMapping(value = "/rates/{baseCurrency}")
    public String getRates(Model model, @PathVariable String baseCurrency) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        List<Map<String, Object>> jsonResponses = utils.getRatesForLastTenDays(baseCurrency);
        model.addAttribute("currentDate", dateFormat.format(date));
        model.addAttribute("baseCurrency", baseCurrency.toUpperCase());
        model.addAttribute("jsonResponse", jsonResponses);
        model.addAttribute("lastTenDays", utils.getLastTenDays());
        model.addAttribute("currencySymbols", ResourcesReader.readCurrencies());

        return "rates";
    }

}
