package com.semi.oliveold.delivery.service;

import com.semi.oliveold.delivery.repository.DeliveryMapper;
import com.semi.oliveold.order.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryMapper mapper;

    public DeliveryService(DeliveryMapper mapper) {
        this.mapper = mapper;
    }

    public List<OrderDTO> selectDeliveryList(String memberId) {

        List<OrderDTO> order = mapper.selectDeliveryList(memberId);

        return order;
    }

}
