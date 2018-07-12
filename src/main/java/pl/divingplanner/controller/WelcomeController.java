package pl.divingplanner.controller;

import pl.divingplanner.excelservice.DataColecting;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.divingplanner.model.Profile;
import java.io.IOException;

@Controller
public class WelcomeController {


    @Autowired
    private DataColecting dataColecting;

    @GetMapping("/profile")
    public String profileForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String getProfile(@ModelAttribute Profile profile, BindingResult errors, Model model) throws IOException, InvalidFormatException {

        dataColecting.getStopsByDeapth(profile);

        return "result";
    }



}

