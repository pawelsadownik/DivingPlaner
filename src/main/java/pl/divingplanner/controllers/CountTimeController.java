package pl.divingplanner.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.divingplanner.calculations.TimeUnderWater;



@Controller
public class CountTimeController {

    private double tUnderWater;


    @PostMapping("/count/timeUnderwater")
    public String handlePostRequest(@ModelAttribute TimeUnderWater timeUnderWater , BindingResult errors, Model model) {

      tUnderWater=timeUnderWater.countTime(timeUnderWater);

        return "redirect:/count/timeUnderwater";
    }

    @GetMapping("/count/timeUnderwater")
    public String handleGetRequest(@ModelAttribute TimeUnderWater timeUnderWater,  Model model) {

        model.addAttribute("tUnderWater", tUnderWater);

        return "/count/timeUnderwater";
    }

}
