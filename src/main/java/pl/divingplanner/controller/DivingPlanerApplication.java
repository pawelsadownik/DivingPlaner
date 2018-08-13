package pl.divingplanner.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication

@ComponentScan(basePackages = "pl.divingplanner")
public class DivingPlanerApplication implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){

        registry.addViewController("/home").setViewName("home");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DivingPlanerApplication.class, args);
    }

}
