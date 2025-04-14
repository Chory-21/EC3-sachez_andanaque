package com.example.EC3_sachez_andanaque.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Value("${mensaje:Default mensaje}")
    private String mensaje;

    @GetMapping("/mensaje")
    public String getMensaje(){
        return mensaje;
    }
}
