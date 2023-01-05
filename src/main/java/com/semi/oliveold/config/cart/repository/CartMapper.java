package com.semi.oliveold.config.cart.repository;

import com.semi.oliveold.config.cart.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartDTO> findByAll();

}
