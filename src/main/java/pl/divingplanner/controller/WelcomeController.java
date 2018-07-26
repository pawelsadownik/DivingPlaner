package pl.divingplanner.controller;

import pl.divingplanner.excelservice.DataColecting;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.divingplanner.excelservice.ExcelReader;
import pl.divingplanner.model.DivingProces;
import pl.divingplanner.model.Email;
import pl.divingplanner.model.Profile;

import java.awt.*;
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
        emailService.send(email.getAddress(), email.getTitle(), email.getContent());
       //model.addAttribute("address", address);
        return "email";


    }


}

