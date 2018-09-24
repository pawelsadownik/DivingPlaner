package pl.divingplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.calculations.PartialPressure;


@Controller
public class PartialPressureController {
    double pPressure;
    double fraction;
    double depth;

    @PostMapping(value ="/count/partialPressure", params = "countPartialPressure")
    public String handlePartialPressure(@ModelAttribute PartialPressure partialPressure, BindingResult errors, Model model) {

        pPressure = partialPressure.countPartialPressure(partialPressure);
        pPressure *= 100;
        pPressure = Math.round(pPressure);
        pPressure /= 100;

        return "redirect:/count/partialPressure";
    }
    @PostMapping(value ="/count/partialPressure", params = "countFraction")
    public String handleFraction(@ModelAttribute PartialPressure partialPressure, BindingResult errors, Model model) {

        fraction = partialPressure.countFraction(partialPressure);
        fraction *= 100;
        fraction = Math.round(fraction);
        fraction /= 100;

        return "redirect:/count/partialPressure";
    }
    @PostMapping(value ="/count/partialPressure", params = "countDepth")
    public String handleDepth(@ModelAttribute PartialPressure partialPressure, BindingResult errors, Model model) {

        depth = partialPressure.countDepth(partialPressure);
        depth *= 100;
        depth = Math.round(depth);
        depth /= 100;

        return "redirect:/count/partialPressure";
    }

    @GetMapping("/count/partialPressure")
    public String handleGetRequest(@ModelAttribute PartialPressure partialPressure, Model model) {

        model.addAttribute("pPressure", pPressure);
        model.addAttribute("depth", depth);
        model.addAttribute("fraction", fraction);

        return "/count/partialPressure";
    }
}
