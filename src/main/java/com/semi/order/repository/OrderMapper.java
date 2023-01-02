package com.semi.order.repository;

import com.semi.order.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDTO> selectOrderList();
}
