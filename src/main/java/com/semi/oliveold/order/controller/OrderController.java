package com.semi.oliveold.order.controller;

import com.semi.oliveold.member.dto.MemberDTO;
import com.semi.oliveold.member.dto.UserImpl;
import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.OrderMemberDTO;
import com.semi.oliveold.order.dto.ProductDTO;
import com.semi.oliveold.order.service.OrderService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/registOrder")
    public String insertOrderMenu(@AuthenticationPrincipal User user, @RequestParam int productNo) {

        System.out.println("no =========== : " + productNo);
        /*String memberId = "user01";*/
        System.out.println("user.getUsername() = " + user.getUsername());
        OrderDTO order = new OrderDTO();
        order.setProductNo(productNo);
        order.setMemberId(user.getUsername());

        int result =  orderService.insertOrderMenu(order);

        System.out.println("orderNo===========" + order);

        return "redirect:/order/orderProductDetail/"+ order.getOrderNo();
    }
    @GetMapping("/orderProductDetail/{orderNo}")
    public ModelAndView selectOrderMenu(@AuthenticationPrincipal User user, @PathVariable("orderNo") int orderNo, ModelAndView mv){

        /*String memberId = "user01";*/
        System.out.println("orderNo ==============> " + orderNo);

        // productNo
        int productNo = orderService.selectProductNo(orderNo);

        ProductDTO product = orderService.selectProduct(productNo);
        System.out.println("product ================> " + product);
        OrderMemberDTO member = orderService.selectMember(user.getUsername());
        System.out.println("member ==================> " + member);
        OrderDTO order = orderService.selectOrderQuan(orderNo);

        String[] phoneNum = member.memberPhone.split("-");
        for(int i = 0; i < phoneNum.length; i++){
            member.setPhone1(phoneNum[0]);
            member.setPhone2(phoneNum[1]);
            member.setPhone3(phoneNum[2]);
        }

        String[] arrAddress = member.memberAddress.split("/");

        for (int i = 0; i <arrAddress.length; i++){
            member.setZipcode(arrAddress[0]);
            member.setAddress1(arrAddress[1]);
            member.setAddress2(arrAddress[2]);
        }

        System.out.println("order = " + order);
        mv.addObject("product", product);
        mv.addObject("member", member);
        mv.addObject("order", order);

        System.out.println("확인용 ===============>>>>>>");
        mv.setViewName("/order-payment");

        return mv;
    }

}
