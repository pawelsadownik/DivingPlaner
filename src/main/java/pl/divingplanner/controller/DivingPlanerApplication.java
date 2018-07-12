package pl.divingplanner.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "pl.divingplanner")
public class DivingPlanerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DivingPlanerApplication.class, args);
    }

}
