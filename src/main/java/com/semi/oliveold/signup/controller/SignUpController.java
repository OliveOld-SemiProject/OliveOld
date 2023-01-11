package com.semi.oliveold.signup.controller;

import com.semi.oliveold.member.dto.MemberDTO;
import com.semi.oliveold.member.exception.MemberJoinException;
import com.semi.oliveold.signup.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Slf4j
@RequestMapping("/signup")
@Controller
public class SignUpController {

    SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public String signUpMainView(){

        return "signup";
    }

    @PostMapping("/join")
    public String DoSignUp(HttpServletRequest request, Model model) throws MemberJoinException {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String rawPassword = request.getParameter("passwd");
        String encodePassword = bCryptPasswordEncoder.encode(rawPassword);

//        log.info("***signUpController.signUpMainView : {} :?: {}***" , rawPassword, encodePassword);

        MemberDTO member = new MemberDTO();

        member.setMemberId(request.getParameter("member_id"));
        member.setMemberPwd(encodePassword);
        member.setMemberName(request.getParameter("name"));
        member.setMemberAddress(request.getParameter("postcode1"));

        String mobile = request.getParameter("mobile1") + "-"
                + request.getParameter("mobile2") + "-"
                + request.getParameter("mobile3");

        member.setMemberPhone(mobile);
        member.setMemberISAD(request.getParameter("is_sms"));
        member.setMemberEmail(request.getParameter("email1"));
        member.setMemberGender(request.getParameter("is_sex"));

        String identifier = request.getParameter("birth_year")
                + request.getParameter("birth_month")
                + request.getParameter("birth_day");
                //+ request.getParameter("is_solar_calendar");

        member.setMemberIdentifier(identifier);
        member.setMemberType("일반회원");
        member.setMemberLevel("baby");
        member.setMemberRegistDate(new Date());

        log.info("**init memberDTO : {}**", member);

        signUpService.insertMember(member);

        return "/login";
    }


}
