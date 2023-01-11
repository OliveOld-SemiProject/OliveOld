package com.semi.oliveold.delivery.repository;

import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.PaymentDTO;
import com.semi.oliveold.order.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    PaymentDTO selectPayment(String memberId);

    OrderDTO selectOrder(String memberId);

    ProductDTO selectDeliveryList(int productNo);
}
