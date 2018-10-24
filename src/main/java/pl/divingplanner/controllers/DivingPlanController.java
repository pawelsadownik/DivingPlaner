package pl.divingplanner.controllers;

import com.itextpdf.text.DocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.excelService.DataColecting;
import pl.divingplanner.model.DivingPlan;
import pl.divingplanner.model.DivingProces;
import pl.divingplanner.model.Profile;
import pl.divingplanner.model.Risk;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class DivingPlanController {

    @Autowired
    private DataColecting dataColecting;

    @GetMapping("/divingPlanForm")
    public String divingPlanForm(Model model) throws IOException, InvalidFormatException {
        model.addAttribute("divingPlan", new DivingPlan());
        model.addAttribute("profile", new Profile());
        return "divingPlanForm";
    }
    @PostMapping("/divingPlanForm")
    public String prepareDivingPlan(@ModelAttribute DivingPlan divingPlan, Profile profile, BindingResult errors, @ModelAttribute Risk risk, Model model) throws DocumentException, IOException, ParserConfigurationException, InvalidFormatException {

        DivingProces divingProces = new DivingProces();

        List<Integer> time = new LinkedList<>();
        int sum=0;
        for (int i=0;i<divingProces.getTimeStopsList().size();i++){
            sum = sum + divingProces.getTimeStopsList().get(i);
            time.add(sum);
        }

        List<Integer> depth = new LinkedList<>(divingProces.getDepthStopsList());
        List<Integer> timeBreak = new LinkedList<>(divingProces.getTimeStopsListBreak());
        List<Integer> depthBreak = new LinkedList<>(divingProces.getDepthStopsListBreak());

        profile.getCounterBreak();
        model.addAttribute("time", time);
        model.addAttribute("depth", depth);
        model.addAttribute("timeBreak", timeBreak);
        model.addAttribute("depthBreak", depthBreak);
        model.addAttribute("counterBreak", profile.getCounterBreak());

        //PdfDocument pdfDocument = new PdfDocument();
        //pdfDocument.generatePDFFromHTML(HTML);

        return "divingPlanReady";

    }
}
