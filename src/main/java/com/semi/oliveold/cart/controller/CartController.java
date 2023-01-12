package com.semi.oliveold.cart.controller;

import com.semi.oliveold.cart.dto.CartResultDTO;
import com.semi.oliveold.cart.service.CartService;
import com.semi.oliveold.cart.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cartList")
public class CartController {
    private final CartService cartService;
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping
    public String findProductByMemberID(@AuthenticationPrincipal User user, Model model){
        log.info("*******CartController.findProductByMemberID******");

        List<CartResultDTO> items = cartService.findProductByMemberID(user.getUsername());
        model.addAttribute("items", items);

        return "shoppingCart";
    }
//    @PostMapping
//    public String findById(@AuthenticationPrincipal User user, Model model){
//        log.info("Play findAll");
//
//        List<CartDTO> items = cartService.findById(user.getUsername());
//        model.addAttribute("items", items);
//
//        return "shoppingCart";
//    }

    @PostMapping("/delete")
    public String deleteByCartId(@AuthenticationPrincipal User user, HttpServletRequest request, Model model){

        int result = cartService.deleteByCartId(Integer.parseInt(request.getParameter("cart_no")));
        log.info("**  delete result = {}  **", result);

        List<CartDTO> items = cartService.findById(user.getUsername());
        model.addAttribute("items", items);

        return "shoppingCart";
    }
}
