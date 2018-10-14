package pl.divingplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexConctroller {

    @GetMapping ("/index")
    public String index()  {

        return "index";
    }
}
