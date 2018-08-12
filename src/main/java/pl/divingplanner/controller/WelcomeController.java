package pl.divingplanner.controller;

import pl.divingplanner.excelservice.DataColecting;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.divingplanner.model.*;

import java.io.IOException;
import java.util.*;
import java.util.List;

@Controller
public class WelcomeController extends DivingProces {

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
        depthStopsList.clear();
        timeStopsList.clear();

        dataColecting.getStopsByDeapth(profile);

        List<Integer> time = new LinkedList<>(getTimeStopsList());

        List<Integer> depth = new LinkedList<>(getDepthStopsList());

        //do wsyswietlenia wynikow na result

        model.addAttribute("time", time);

        model.addAttribute("depth", depth);

        Email email = new Email();

        model.addAttribute("email", email);

        return "result";
    }
    @GetMapping("/result")
    public String email(Model model) throws IOException, InvalidFormatException {

        model.addAttribute("email", new Email());


        return "email";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute Email email, BindingResult errors, Model model) {

       // email.setContent( z sesji );
        emailService.send(email);
       //model.addAttribute("address", address);
        return "email";


    }
    @GetMapping("/divingPlanForm")
    public String divingPlanForm(Model model) throws IOException, InvalidFormatException {
        model.addAttribute("divingPlan", new DivingPlan());
        model.addAttribute("risk", new Risk());

        return "divingPlanForm";
    }
    @PostMapping("/divingPlanForm")
    public String prepareDivingPlan(@ModelAttribute DivingPlan divingPlan, BindingResult errors, @ModelAttribute Risk risk, Model model) {

       // List<Risk> riskList = new LinkedList<Risk>(risk);
        //model.addAttribute("riskList", riskList);
        divingPlan.getRiskList().add(risk);


        return "divingPlanReady";

    }

}

