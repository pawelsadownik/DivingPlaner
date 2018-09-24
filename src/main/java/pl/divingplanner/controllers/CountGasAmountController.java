package pl.divingplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.calculations.GasAmount;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CountGasAmountController {
    private double gAmount;

    @PostMapping("/count/gasAmount")
    public String handlePostRequest(@ModelAttribute GasAmount gasAmount , BindingResult errors, Model model) {


        gAmount= gasAmount.countGasAmount(gasAmount);

        gAmount *= 100;
        gAmount= Math.round(gAmount);
        gAmount /= 100;


        return "redirect:/count/gasAmount";
    }

    @GetMapping("/count/gasAmount")
    public String handleGetRequest(@ModelAttribute GasAmount gasAmount, Model model) {

        model.addAttribute("gAmount", gAmount);

        return "/count/gasAmount";
    }
}
