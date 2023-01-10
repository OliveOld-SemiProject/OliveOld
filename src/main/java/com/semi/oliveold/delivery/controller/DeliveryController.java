package com.semi.oliveold.delivery.controller;

import com.semi.oliveold.delivery.service.DeliveryService;
import com.semi.oliveold.delivery.dto.DeliveryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {

    // 로그정보를 처리하는 객체 생성
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //OrderService로 이동
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    //localHost:8080/order/list
    @GetMapping(value = "/list")
    public ModelAndView deliveryList(HttpServletRequest request, ModelAndView mv){

        List<DeliveryDTO> deliveryList = deliveryService.selectDeliveryList();

        log.info("[OrderController] deliveryList : " + deliveryList);

        mv.addObject("deliveryList", deliveryList);

        mv.setViewName("/order-delivery");

        return mv;
    }



    /*//index
    @RequestMapping("/index")
    public String doIndex(){
        return "/index.html";
    }

    //로그인
    @RequestMapping("/login.html")
    public String doLogin(){
        return "redirect:/login.html";
    }

    //회원가입
    @GetMapping("/signup.html")
    public String goSignUp(){
        return "redirect:/signup.html";
    }

    //쇼핑카드
    @GetMapping("/shoppingCart.html")
    public String goShoppingCart(){
        return "redirect:/cartList";
    }

    //공지사항
    @GetMapping("/Notice.html")
    public String goNotice(){
        return "redirect:/Notice.html";
    }*/
}
