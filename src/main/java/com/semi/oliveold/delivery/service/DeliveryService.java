package com.semi.oliveold.delivery.service;

import com.semi.oliveold.delivery.repository.DeliveryMapper;
import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.PaymentDTO;
import com.semi.oliveold.order.dto.ProductDTO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final DeliveryMapper mapper;

    public DeliveryService(DeliveryMapper mapper) {
        this.mapper = mapper;
    }

    public PaymentDTO selectPayment(String memberId) {

        PaymentDTO payment = mapper.selectPayment(memberId);

        return payment;
    }

    public OrderDTO selectOrder(String memberId) {

        OrderDTO order = mapper.selectOrder(memberId);

        return order;
    }

    public ProductDTO selectDeliveryList(int productNo) {

        ProductDTO product = mapper.selectDeliveryList(productNo);

        return product;
    }
}
