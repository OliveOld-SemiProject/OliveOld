package com.semi.oliveold.order.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private int productNo;

    private String productName;

    private int productPrice;

    private int productQuan;

    private Date productDate;

    private String productStatus;

    private String productImage1;

    private String productImage2;

    private int categoryCode;

    private String categoryName;


}
