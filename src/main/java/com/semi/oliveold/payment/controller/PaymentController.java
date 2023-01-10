package com.semi.oliveold.payment.controller;

import com.semi.oliveold.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    // 로그정보를 처리하는 객체 생성
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    /*    @GetMapping("/new")
        public String newPaymentForm(){

            return "order-payment";
        }*/
    @GetMapping("/list")
    public String goCreate() {
        return "order-payment";
    }

  /*  @PostMapping("/list")
    public String createPayment(@ModelAttribute OrderDTO orderDTO, HttpServletRequest request, RedirectAttributes rttr){

        String phone = request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-" + request.getParameter("phone3");
        String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
        orderDTO.setAddress(address);
        orderDTO.setPhone(phone);

        paymentService.createPayment(payment);

        System.out.println(payment);

        return "redirect:/";
    }*/




}
