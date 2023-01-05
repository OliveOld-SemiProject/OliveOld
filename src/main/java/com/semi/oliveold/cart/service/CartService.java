package com.semi.oliveold.cart.service;

import com.semi.oliveold.cart.repository.CartMapper;
import com.semi.oliveold.cart.dto.CartDTO;
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
