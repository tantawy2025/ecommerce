package com.example.ecommerce.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("welcome")
public class WelcomeResource {


    @GetMapping
    public String welcome(){
        return "welcome to our ecommerce project";
    }
}
