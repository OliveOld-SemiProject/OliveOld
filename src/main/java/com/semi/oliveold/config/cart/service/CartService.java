package com.semi.oliveold.config.cart.service;

import com.semi.oliveold.config.cart.dto.CartDTO;
import com.semi.oliveold.config.cart.repository.CartMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    CartMapper cartMapper;
    public CartService(CartMapper cartMapper){
        this.cartMapper = cartMapper;
    }

    public List<CartDTO> findAll(){
        System.out.println("CartService call");
        return cartMapper.findByAll();
    }
}
