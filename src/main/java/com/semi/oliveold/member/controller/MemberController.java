package com.semi.oliveold.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @GetMapping("/login")
    public String memberLoginForm() {
        log.info("**MemberController.memberLoginForm**");
        return "login";
    }

    @PostMapping("/logout")
    public String memberLogoutForm(){
        return "/";
    }

    @GetMapping("/changePwdView")
    public String changePwdView(){
        return "ChangePwd";
    }

    @PostMapping("/changePwd")
    public String changePwd(){

        return "/";
    }

}
