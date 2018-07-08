package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"Model", "excelservice", "controller"})
@PropertySource("classpath:application.properties")
public class DivingPlanerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DivingPlanerApplication.class, args);
    }

}
