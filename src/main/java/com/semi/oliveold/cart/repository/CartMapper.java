package com.semi.oliveold.cart.repository;

import com.semi.oliveold.cart.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartDTO> findByAll();

    List<CartDTO> findById(String memberId);

    int deleteByCartId(int cartNo);

}
