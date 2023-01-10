package com.semi.oliveold.payment.repository;

import com.semi.oliveold.order.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    int createPayment(OrderDTO payment);
}
