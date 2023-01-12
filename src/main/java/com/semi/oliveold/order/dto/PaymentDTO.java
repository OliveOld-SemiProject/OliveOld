package com.semi.oliveold.order.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private int paymentNo;

    private Date paymentDate;

    private int paymentAmount;

    private String memberId;
}
