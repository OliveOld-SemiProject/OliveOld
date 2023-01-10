package com.semi.oliveold.order.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private int productNo; //제품번호
    private int orderNo; //주문번호
    private Date orderDate; //주문일
    private int orderQuan; //주문 수량
    private String memberId; //주문 아이디
}
