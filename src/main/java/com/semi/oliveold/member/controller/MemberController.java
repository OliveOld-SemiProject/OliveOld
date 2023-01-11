package com.semi.oliveold.member.controller;

import com.semi.oliveold.member.exception.MemberJoinException;
import com.semi.oliveold.member.service.ChangePwdService;
import com.semi.oliveold.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

    ChangePwdService memberService;

    public MemberController(ChangePwdService changePwdService) {
        this.memberService = changePwdService;
    }

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
    public String changePwd(@AuthenticationPrincipal User user, HttpServletRequest request) throws MemberJoinException {

        log.info("****************changePwd Controller********************************");
        memberService.changePwd(user.getUsername(), request.getParameter("oldPwd"), request.getParameter("newPwd"));

        return "redirect:/";
    }

    @GetMapping
    public String mainView(){
        return "/";
    }

}
