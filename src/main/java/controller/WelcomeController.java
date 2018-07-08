package controller;

import excelservice.DataColecting;
import excelservice.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import Model.Profile;
import java.io.IOException;

@Controller
@PropertySource("classpath:application.properties")

public class WelcomeController {


    @Autowired
    private DataColecting dataColecting;

    @GetMapping("/profile")
    public String profileForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ResponseBody
    public String getProfile(@ModelAttribute Profile profile, BindingResult errors, Model model) throws IOException, InvalidFormatException {

        dataColecting.getStopsByDeapth(profile);

        return "result";
    }



}

