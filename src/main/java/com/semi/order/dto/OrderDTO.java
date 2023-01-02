package com.semi.order.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private int no;
    private Date date;
    private String productName;
    private int productQuan;
    private int price;
    private String delivery;

}
