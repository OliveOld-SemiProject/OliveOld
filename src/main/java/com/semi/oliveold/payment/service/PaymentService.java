package com.semi.oliveold.payment.service;

import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.payment.repository.PaymentMapper;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentMapper mapper;

    public PaymentService(PaymentMapper mapper) {
        this.mapper = mapper;
    }

    public void createPayment(OrderDTO payment) {

        int result = mapper.createPayment(payment);

        if(!(result > 0 )){
            System.out.println("주문/결제에 실패하였습니다.");
        }
    }


}
