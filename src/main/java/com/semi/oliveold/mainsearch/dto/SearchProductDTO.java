package com.semi.oliveold.mainsearch.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchProductDTO {

    private long no;
    private String name;
    private long price;
    private long quan;
    private Date date;
    private String status;
    private String image1;
    private String image2;
    private SearchProductCategoryDTO searchProductCategory;

}
