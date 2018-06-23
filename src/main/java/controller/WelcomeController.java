package controller;

import ExcelService.DataColecting;
import ExcelService.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import Model.Profile;

import java.io.IOException;
import java.util.Map;

@Controller
public class WelcomeController {

    @GetMapping("/profile")
    public String profileForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String getProfile(@ModelAttribute Profile profile, BindingResult errors, Model model) throws IOException, InvalidFormatException {

        DataColecting dataColecting = new DataColecting();

        dataColecting.getStopsByDeapth(profile);

        return "result";
    }



}

