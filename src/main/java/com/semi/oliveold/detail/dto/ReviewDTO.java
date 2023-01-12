package com.semi.oliveold.detail.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDTO {

    private int reviewNo;
    private String reviewContents;
    private String reviewWriter;
    private int reviewReply;
    private int productNo;



}
