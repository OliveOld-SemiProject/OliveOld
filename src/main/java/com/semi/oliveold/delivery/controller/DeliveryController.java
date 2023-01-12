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


    //localHost:8080/delivery/list
    @GetMapping(value = "/list")
    public ModelAndView selectDeliveryList(@AuthenticationPrincipal User user, ModelAndView mv) {

        // memberId, productNo --> 한번에 쓰고 싶다.
        // 두가지 방식을 사용해볼 수 있는데
        // 1. 두개의 값을 가지고 있는 DTO 객체안에다가 집어놓고 사용
        List<OrderDTO> order = deliveryService.selectDeliveryList(user.getUsername());

        // 2. HashMap을 이용해서 넣어서 사용

        mv.addObject("order", order);

        System.out.println("name================" + user.getUsername());

        System.out.println("==========나와랏===================");

        mv.setViewName("order-delivery");

        return mv;

        /*List<DeliveryDTO> deliveryList = deliveryService.selectDeliveryList();

        log.info("[OrderController] deliveryList : " + deliveryList);

        mv.addObject("deliveryList", deliveryList);

        mv.setViewName("/order-delivery");

        return mv;*/

    }

}
