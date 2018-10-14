package pl.divingplanner.controllers;

import com.itextpdf.text.DocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.divingplanner.model.DivingPlan;
import pl.divingplanner.model.Risk;
import pl.divingplanner.pdfCreation.PdfDocument;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
public class DivingPlanController {

    @GetMapping("/divingPlanForm")
    public String divingPlanForm(Model model) throws IOException, InvalidFormatException {
        model.addAttribute("divingPlan", new DivingPlan());

        return "divingPlanForm";
    }
    @PostMapping("/divingPlanForm")
    public String prepareDivingPlan(@ModelAttribute DivingPlan divingPlan, BindingResult errors, @ModelAttribute Risk risk, Model model) throws DocumentException, IOException, ParserConfigurationException {

        final String HTML = "src/main/resources/templates/divingPlanReady.html";

        //PdfDocument pdfDocument = new PdfDocument();
        //pdfDocument.generatePDFFromHTML(HTML);

        return "divingPlanReady";

    }
}
