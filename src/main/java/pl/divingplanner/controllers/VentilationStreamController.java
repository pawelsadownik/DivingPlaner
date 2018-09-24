package pl.divingplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.calculations.VentilationStream;


@Controller
public class VentilationStreamController {
    private double ventStream;

    @PostMapping("/count/ventilationStream")
    public String handlePostRequest(@ModelAttribute VentilationStream ventilationStream, BindingResult errors, Model model) {

        ventStream= ventilationStream.countStreamOfVent(ventilationStream);

        ventStream *= 100;
        ventStream= Math.round(ventStream);
        ventStream /= 100;


        return "redirect:/count/ventilationStream";
    }

    @GetMapping("/count/ventilationStream")
    public String handleGetRequest(@ModelAttribute VentilationStream ventilationStream, Model model) {

        model.addAttribute("ventStream", ventStream);

        return "/count/ventilationStream";
    }
}
