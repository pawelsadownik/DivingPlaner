package pl.divingplanner.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.model.DivingPlan;
import pl.divingplanner.model.Risk;
import pl.divingplanner.wrappers.DivingPlanWrapper;
import pl.divingplanner.wrappers.RiskWrapper;

import java.util.Arrays;
import java.util.List;

@Controller
public class RiskController {
    @GetMapping("/riskForm")
    public String showCreateRiskForm(@ModelAttribute RiskWrapper riskWrapper, DivingPlanWrapper divingPlanWrapper, BindingResult errors, Risk risk, DivingPlan divingPlan, Model model) {

        riskWrapper.setRiskList(Arrays.asList(risk));
        divingPlanWrapper.setDivingPlanList(Arrays.asList(divingPlan));

        return "riskForm";
    }


    @PostMapping("/riskForm")
    public String saveRisks(@ModelAttribute RiskWrapper riskWrapper, DivingPlanWrapper divingPlanWrapper, Risk risk,BindingResult errors,DivingPlan divingPlan, Model model) {

        return "allRisks";
    }

    @PostMapping(value = "/riskForm", params = "addRow")
    public String addRow(@ModelAttribute RiskWrapper riskWrapper, DivingPlanWrapper divingPlanWrapper,  Risk risk, Model model) {

        List<Risk> list = riskWrapper.getRiskList();

        list.add(new Risk());

        riskWrapper.setRiskList((list));

        return "riskForm";
    }

    @PostMapping(value = "/riskForm", params = "addSec")
    public String addSec(@ModelAttribute DivingPlanWrapper divingPlanWrapper, RiskWrapper riskWrapper, DivingPlan divingPlan,BindingResult errors, Model model) {

        List<DivingPlan> list = divingPlanWrapper.getDivingPlanList();

        list.add(new DivingPlan());

        divingPlanWrapper.setDivingPlanList((list));

        return "riskForm";
    }
}
