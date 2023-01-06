package com.semi.oliveold.detail.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetailDTO {

    private int productNo;
    private String productName;
    private int productPrice;
    private int productQuan;
    private Date productDate;
    private String productCategory;
    private String productStatus;
    private String productImage1;
    private String productImage2;




}
