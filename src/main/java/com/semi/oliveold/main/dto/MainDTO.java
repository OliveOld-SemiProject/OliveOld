package com.semi.oliveold.main.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MainDTO {

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
