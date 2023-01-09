package com.semi.oliveold.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
@Slf4j
public class MainIndex {

    @PostMapping
    public String postMainPage(@AuthenticationPrincipal User user){
        return "index";
    }
    @GetMapping
    public String getmMainPage(){
        return "index";
    }
}
