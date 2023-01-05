package com.semi.oliveold.order.service;

import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.repository.OrderMapper;
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
