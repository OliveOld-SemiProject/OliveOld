package com.semi.oliveold.cart.service;

import com.semi.oliveold.cart.repository.CartMapper;
import com.semi.oliveold.cart.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartService {

    CartMapper cartMapper;
    public CartService(CartMapper cartMapper){
        this.cartMapper = cartMapper;
    }

    public List<CartDTO> findById(String memberId){
        log.info("CartService.findById");
        return cartMapper.findById(memberId);
    }

    public int deleteByCartId(int cartNo){
        log.info("**CartService.deleteByCartId**");
        return cartMapper.deleteByCartId(cartNo);
    }
}
