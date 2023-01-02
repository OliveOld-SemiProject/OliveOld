package com.semi.order.service;

import com.semi.order.dto.OrderDTO;
import com.semi.order.repository.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderMapper mapper;

    public OrderService(OrderMapper mapper) {
        this.mapper = mapper;
    }

    public List<OrderDTO> selectOrderList(){

        List<OrderDTO> orderList = mapper.selectOrderList();

        return orderList;
    }
}
