package com.semi.oliveold.cart.controller;

import com.semi.oliveold.cart.service.CartService;
import com.semi.oliveold.cart.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String findAll(Model model){
        log.info("Play findAll");

        List<CartDTO> items = cartService.findAll();
        model.addAttribute("items", items);

        return "shoppingCart";
    }
}
