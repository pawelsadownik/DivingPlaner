package pl.divingplanner.controllers;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.divingplanner.model.Profile;

import java.io.IOException;

@Controller
public class CountController {

    @RequestMapping(value = "/calculations", method = RequestMethod.GET)
    public String calculation(Model model) throws IOException, InvalidFormatException {


        return "calculations";
    }
}
