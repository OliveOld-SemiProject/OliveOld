package com.semi.oliveold.delivery.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {

    /*order-delivery*/
    private int no; //주문번호
    private Date date; //주문일자
    private String productName; //상품명
    private int productQuan; //수량
    private int price; //가격
    private String delivery; //배송상태

    /*order-payment*/

    private String deliveryArea; //배송지 선택
    private String name; //배송받는 사람
    private String phone; //연락처
    private String address; //주소
    private String deliveryCoupon; //배송쿠폰
    private int mileage; //적립금
    private int plusMileage; // 추가적립금
    private int useMileage; //사용적립금
    private int totalPrice; //최종결제금액
}
