package com.semi.oliveold.delivery.controller;

import com.semi.oliveold.delivery.service.DeliveryService;
import com.semi.oliveold.order.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class DeliveryController {

    // 로그정보를 처리하는 객체 생성
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //deliveryService로 이동
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    //localHost:8080/order/list
    // memberId로 주문내역 조회하기
    @GetMapping(value = "/list")
    public ModelAndView selectDeliveryList(@AuthenticationPrincipal User user, ModelAndView mv) {

        List<OrderDTO> order = deliveryService.selectDeliveryList(user.getUsername());

        mv.addObject("order", order);

        System.out.println("name================" + user.getUsername());

        System.out.println("==========나와랏===================");

        mv.setViewName("order-delivery");

        return mv;

    }

}
