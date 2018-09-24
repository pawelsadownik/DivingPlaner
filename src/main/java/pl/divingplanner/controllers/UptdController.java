package pl.divingplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.calculations.Uptd;


@Controller
public class UptdController {

    private double unitptd;

    @PostMapping("/count/uptd")
    public String handlePostRequest(@ModelAttribute Uptd uptd, BindingResult errors, Model model) {

        unitptd= uptd.countUptd(uptd);
        unitptd *= 100;
        unitptd= Math.round(unitptd);
        unitptd /= 100;


        return "redirect:/count/uptd";
    }

    @GetMapping("/count/uptd")
    public String handleGetRequest(@ModelAttribute Uptd uptd, Model model) {

        model.addAttribute("unitptd", unitptd);

        return "/count/uptd";
    }
}
