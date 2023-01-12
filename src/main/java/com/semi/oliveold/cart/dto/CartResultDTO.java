package com.semi.oliveold.cart.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CartResultDTO {

    private int Cart_no;
    private String PRODUCT_NAME;
    private int cart_amount;
    private String PRODUCT_IMAGE1;
    private int PRODUCT_PRICE;
}
