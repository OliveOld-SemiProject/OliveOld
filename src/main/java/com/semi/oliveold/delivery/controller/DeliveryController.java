package com.semi.oliveold.delivery.controller;

import com.semi.oliveold.delivery.service.DeliveryService;
import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.OrderMemberDTO;
import com.semi.oliveold.order.dto.PaymentDTO;
import com.semi.oliveold.order.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    //localHost:8080/delivery/list
    @GetMapping(value = "/list")
    public ModelAndView selectDeliveryList(@AuthenticationPrincipal User user, @RequestParam int productNo ,ModelAndView mv) {

        System.out.println("user.getUsername()======================" + user.getUsername());

        System.out.println("productNo" + productNo);
        PaymentDTO payment = deliveryService.selectPayment(user.getUsername());

        OrderDTO order = deliveryService.selectOrder(user.getUsername());

        ProductDTO product = deliveryService.selectDeliveryList(productNo);

        mv.addObject("payment", payment);
        mv.addObject("order", order);
        mv.addObject("product", product);

        System.out.println("==========나와랏===================");

        mv.setViewName("/order-delivery");

        return mv;
        /*List<DeliveryDTO> deliveryList = deliveryService.selectDeliveryList();

        log.info("[OrderController] deliveryList : " + deliveryList);

        mv.addObject("deliveryList", deliveryList);

        mv.setViewName("/order-delivery");

        return mv;*/

    }

}
