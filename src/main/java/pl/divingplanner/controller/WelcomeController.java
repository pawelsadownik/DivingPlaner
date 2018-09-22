package pl.divingplanner.controller;

import pl.divingplanner.calculations.GasAmount;
import pl.divingplanner.calculations.TimeUnderWater;
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
public class WelcomeController {

    private List<Double> gasAmounts = new ArrayList<>();
    private List<Double> timesUnderWater = new ArrayList<>();


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
        //emailService.send(email);
       //model.addAttribute("address", address);
        return "email";


    }
    @GetMapping("/divingPlanForm")
    public String divingPlanForm(Model model) throws IOException, InvalidFormatException {
        model.addAttribute("divingPlan", new DivingPlan());


        return "divingPlanForm";
    }
    @PostMapping("/divingPlanForm")
    public String prepareDivingPlan(@ModelAttribute DivingPlan divingPlan, BindingResult errors, @ModelAttribute Risk risk, Model model) {



        return "divingPlanReady";

    }

    @GetMapping("/riskForm")
    public String showCreateRiskForm(@ModelAttribute RiskWrapper riskWrapper,Risk risk,  Model model) {

        riskWrapper.setRiskList(Arrays.asList(risk));

        return "riskForm";
    }


    @PostMapping("/riskForm")
    public String saveRisks(@ModelAttribute RiskWrapper riskWrapper, Risk risk, Model model) {

        return "allRisks";
    }

    @PostMapping(value = "/riskForm", params = "addRow")
    public String addRow(@ModelAttribute RiskWrapper riskWrapper, Risk risk, Model model) {

            List<Risk> list = riskWrapper.getRiskList();
            
            list.add(new Risk());

            riskWrapper.setRiskList((list));

        return "riskForm";
    }


    @PostMapping("/calculations")
    public String handlePostRequest(@ModelAttribute GasAmount gasAmount ,TimeUnderWater timeUnderWater , BindingResult errors, Model model) {
        gasAmounts.clear();
        gasAmount.setAmountOfGas(gasAmount.countGasAmount(gasAmount));
        gasAmounts.add(gasAmount.getAmountOfGas());

        timesUnderWater.clear();
        timeUnderWater.setTime(timeUnderWater.countTime(timeUnderWater));
        timesUnderWater.add(timeUnderWater.getTime());


        return "redirect:/calculations";
    }

    @GetMapping("/calculations")
    public String handleGetRequest(Model model) {

        model.addAttribute("gasamount", new GasAmount());
        model.addAttribute("gasAmounts", gasAmounts);

        model.addAttribute("timeUnderWater", new TimeUnderWater());
        model.addAttribute("timesUnderWater", timesUnderWater);

        return "calculations";
    }
}


