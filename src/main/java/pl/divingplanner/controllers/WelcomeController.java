package pl.divingplanner.controllers;

import pl.divingplanner.calculations.GasAmount;
import pl.divingplanner.calculations.TimeUnderWater;
import pl.divingplanner.emailService.EmailService;
import pl.divingplanner.excelService.DataColecting;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.divingplanner.model.*;
import pl.divingplanner.wrappers.DivingPlanWrapper;
import pl.divingplanner.wrappers.RiskWrapper;

import java.io.IOException;
import java.util.*;
import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private DataColecting dataColecting;
    private EmailService emailService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileForm(Model model) throws IOException, InvalidFormatException {
        model.addAttribute("profile", new Profile());

        return "profile";
    }

    @PostMapping("/profile")
    public String getProfile(@ModelAttribute Profile profile, BindingResult errors, Model model) throws IOException, InvalidFormatException {


        DivingProces divingProces = new DivingProces();

        divingProces.depthStopsList.clear();
        divingProces.timeStopsList.clear();

        dataColecting.getStopsByDeapth(profile);

        List<Integer> time = new LinkedList<>(divingProces.getTimeStopsList());

        List<Integer> depth = new LinkedList<>(divingProces.getDepthStopsList());

        //do wsyswietlenia wynikow na result

        model.addAttribute("time", time);

        model.addAttribute("depth", depth);

        Email email = new Email();

        model.addAttribute("email", email);

        return "result";
    }


    @GetMapping("/result")
    public String email(Model model) throws IOException, InvalidFormatException {

        //model.addAttribute("email", new Email());


        return "email";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute Email email, BindingResult errors, Model model) {

       // email.setContent( z sesji );
        //pl.divingplanner.emailService.send(email);
       //model.addAttribute("address", address);
        return "email";
    }
    @PostMapping(value = "/profile", params = "obliczenia")
    public String obliczenia() {

        return "calculations";
    }
}


