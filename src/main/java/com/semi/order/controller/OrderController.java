package com.semi.order.controller;

import com.semi.order.dto.OrderDTO;
import com.semi.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }

    @GetMapping(value = "/list")
    public ModelAndView orderList(HttpServletRequest request, ModelAndView mv){

        List<OrderDTO> orderList = orderService.selectOrderList();

        log.info("[OrderController] orderList : " + orderList);

        mv.addObject("orderList", orderList);

        mv.setViewName("/order-delivery");

        return mv;
    }

}
