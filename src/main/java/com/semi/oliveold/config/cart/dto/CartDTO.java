package com.semi.oliveold.config.cart.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class CartDTO {

    // 장바구니 번호
    int cart_No;
    // 장바구니에 담은 수량
    int cart_amount;
    //회원의 아이디
    String member_id;
    //상품의 아이디
    int product_no;
    //장바구니에 담은 날짜
    Date cart_insertDate;
}
