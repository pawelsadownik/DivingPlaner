package pl.divingplanner.controller;

import pl.divingplanner.excelservice.DataColecting;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.divingplanner.model.DivingProces;
import pl.divingplanner.model.Profile;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

@Controller
public class WelcomeController {


    @Autowired
    private DataColecting dataColecting;
    //private DivingProces divingProces;

    @GetMapping("/profile")
    public String profileForm(Model model) throws IOException, InvalidFormatException {
        model.addAttribute("profile", new Profile());
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String getProfile(@ModelAttribute Profile profile, BindingResult errors, Model model) throws IOException, InvalidFormatException {

        dataColecting.getStopsByDeapth(profile);

        return "result";
    }

    @GetMapping("/displayBarGraph")
    public String barGraph(Model model) {
        //Map<List, List> surveyMap = new HashMap<>();
        //surveyMap.put(divingProces.getDepthStopsList(), divingProces.getTimeStopsList());

        //model.addAttribute("surveyMap", surveyMap);
        model.addAttribute("divingProces", new DivingProces());
        return "LineGraph";
    }

}

