package com.semi.oliveold.order.controller;

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

        /*String memberId = orderService.findById(user.getUsername());*/
        String memberId = "user01";

        OrderDTO order = new OrderDTO();
        order.setProductNo(productNo);
        order.setMemberId(memberId);

       // rttr.addFlashAttribute("productNo", productNo);

        int result =  orderService.insertOrderMenu(order);

        System.out.println("orderNo===========" + order);
        //return "";

        return "redirect:/order/orderProductDetail/"+ order.getOrderNo();
    }
    @GetMapping("/orderProductDetail/{orderNo}")
    public ModelAndView selectOrderMenu(@AuthenticationPrincipal User user, @PathVariable("orderNo") int orderNo, ModelAndView mv, HttpServletRequest request){


        /*String memberId = orderService.findById(user.getUsername());*/
        String memberId = "user01";
        System.out.println("orderNo = " + orderNo);

        // productNo
        int productNo = orderService.selectProductNo(orderNo);

        ProductDTO product = orderService.selectProduct(productNo);
        System.out.println("product ================> " + product);
        OrderMemberDTO member = orderService.selectMember(memberId);
        System.out.println("member ==================> " + member);
        OrderDTO order = orderService.selectOrderQuan(orderNo);
/*


        String address = request.getParameter("zipCode") + "%" + request.getParameter("address1") + "%" + request.getParameter("address2");
        member.setAddress(address);
        member.setPhone(phone);
        member.setPhone(member.getPhone().replace("-", ""));
*/

        mv.addObject("product", product);
        mv.addObject("member", member);
        mv.addObject("order", order);

        mv.setViewName("/order-payment");

        return mv;
    }

}
