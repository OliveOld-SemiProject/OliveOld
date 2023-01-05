package com.semi.oliveold.discount.controller;


import com.semi.oliveold.discount.service.DiscountService;
import com.semi.oliveold.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/discount")
public class DiscountController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) { this.discountService = discountService; }


    @GetMapping(value = "/list")
    public ModelAndView memberList(HttpServletRequest request, ModelAndView mv){

        List<MemberDTO> memberList = discountService.selectMemberList();

        log.info("[DiscountController] memberList : " + memberList);

        mv.addObject("memberList", memberList);

        mv.setViewName("/payment");

        return mv;
    }


}
