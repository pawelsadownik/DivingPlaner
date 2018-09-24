package pl.divingplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.calculations.MaximumOperationalDepth;


@Controller
public class ModController {
    double maxOperationalDepth;
    @PostMapping("/count/maximumOperationalDepth")
    public String handlePostRequest(@ModelAttribute MaximumOperationalDepth maximumOperationalDepth, BindingResult errors, Model model) {

        maxOperationalDepth = maximumOperationalDepth.countMOD(maximumOperationalDepth);

        maxOperationalDepth *= 100;
        maxOperationalDepth = Math.round(maxOperationalDepth);
        maxOperationalDepth /= 100;

        return "redirect:/count/maximumOperationalDepth";
    }

    @GetMapping("/count/maximumOperationalDepth")
    public String handleGetRequest(@ModelAttribute MaximumOperationalDepth maximumOperationalDepth, Model model) {
        model.addAttribute("maxOperationalDepth", maxOperationalDepth);
        return "/count/maximumOperationalDepth";
    }
}
