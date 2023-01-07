package com.semi.oliveold.signup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/signup")
@Controller
public class signUpController {

    @GetMapping
    public String signUpMainView(){

        return "signup";
    }
}
