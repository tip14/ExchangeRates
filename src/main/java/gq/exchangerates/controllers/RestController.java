package gq.exchangerates.controllers;

import gq.exchangerates.dao.UserRepository;
import gq.exchangerates.model.User;
import gq.exchangerates.utils.ResourcesReader;
import gq.exchangerates.utils.Utils;
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

   @Autowired
   private UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin(@RequestParam(required = false) String logout,
                           @RequestParam(required = false) String  error,
                            Model model) {

        model.addAttribute("logout", logout != null);
        model.addAttribute("error", error != null);

        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }

//    @ModelAttribute(name = "loginField") String login,
//    @ModelAttribute(name = "passwordField") String password,
//    @ModelAttribute(name = "emailField") String email,
//    @ModelAttribute(name = "dateField") String birthday,
//    @ModelAttribute(name = "countryField") String country,

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute User user, Model model){




//        User newUser = user;
//        newUser.setUsername(login);
//        newUser.setPassword(password);
//        newUser.setEmail(email);
//        try {
//            Date birthdayDate = new SimpleDateFormat("dd.MM.YY").parse(birthday);
//            newUser.setBirthday(birthdayDate);
//        } catch (ParseException e) {
//            System.out.println("Can't translate to date birthday: " + birthday);
//            newUser.setBirthday(new Date());
//        }
//        newUser.setCountry(country);

        userRepository.save(user);

        model.addAttribute("successRegistration", "Registration is OK. Use your credentials to log in");



        return "registration";
    }

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
