package com.semi.oliveold.product.dto;

import lombok.*;

import java.util.Date;

@Data
public class RegistProductDTO {

    private int No;

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
