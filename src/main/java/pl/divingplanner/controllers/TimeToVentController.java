package pl.divingplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.calculations.TimeToFirstVent;


@Controller
public class TimeToVentController {
    private double timeToVent;

    @PostMapping("/count/timeToVent")
    public String handlePostRequest(@ModelAttribute TimeToFirstVent timeToFirstVent, BindingResult errors, Model model) {

        timeToVent= timeToFirstVent.countTimeToVent(timeToFirstVent);

        timeToVent *= 100;
        timeToVent= Math.round(timeToVent);
        timeToVent /= 100;


        return "redirect:/count/timeToVent";
    }

    @GetMapping("/count/timeToVent")
    public String handleGetRequest(@ModelAttribute TimeToFirstVent timeToFirstVent, Model model) {

        model.addAttribute("timeToVent", timeToVent);

        return "/count/timeToVent";
    }
}
