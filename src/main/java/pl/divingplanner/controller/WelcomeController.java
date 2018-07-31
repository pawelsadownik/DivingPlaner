package pl.divingplanner.controller;

import pl.divingplanner.excelservice.DataColecting;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.divingplanner.model.DivingProces;
import pl.divingplanner.model.Email;
import pl.divingplanner.model.Profile;
import pl.divingplanner.model.DivingPlan;

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

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
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

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(@ModelAttribute Email email, BindingResult errors, Model model) {

       // email.setContent( z sesji );
        emailService.send(email);
       //model.addAttribute("address", address);
        return "email";


    }
    @GetMapping("/divingPlanForm")
    public String divingPlanForm(Model model) throws IOException, InvalidFormatException {
        model.addAttribute("divingPlan", new DivingPlan());

        return "divingPlanForm";
    }

    @RequestMapping(value = "/divingPlanForm", method = RequestMethod.POST)
    public String prepareDivingPlan(@ModelAttribute DivingPlan divingPlan, BindingResult errors, Model model) {

        List<String> divingType = new LinkedList<>();
        List<String> purpose = new LinkedList<>();
        List<String> risk = new LinkedList<>();
        List<String> security = new LinkedList<>();
        List<String> procedure = new LinkedList<>();
        List<String> equipment = new LinkedList<>();
        List<String> team= new LinkedList<>();
        List<String> commands = new LinkedList<>();
        List<String> communication = new LinkedList<>();
        List<String> asecuration = new LinkedList<>();
        List<String> accident = new LinkedList<>();
        List<String> weatherConditions = new LinkedList<>();
        List<String> evacuation = new LinkedList<>();
        List<String> medic = new LinkedList<>();

        return "divingPlanReady";


    }

}

