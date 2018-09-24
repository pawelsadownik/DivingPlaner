package pl.divingplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.calculations.EquivalentAirDepth;


@Controller
public class EquivalentAirDepthController {
    double EAD;
    @PostMapping("/count/equivalentAirDepth")
    public String handlePostRequest(@ModelAttribute EquivalentAirDepth equivalentAirDepth, BindingResult errors, Model model) {

        EAD= equivalentAirDepth.countEAD(equivalentAirDepth);

        EAD *= 100;
        EAD= Math.round(EAD);
        EAD /= 100;

        return "redirect:/count/equivalentAirDepth";
    }

    @GetMapping("/count/equivalentAirDepth")
    public String handleGetRequest(@ModelAttribute EquivalentAirDepth equivalentAirDepth,Model model) {
        model.addAttribute("EAD", EAD);
        return "/count/equivalentAirDepth";
    }
}
