package com.semi.oliveold.event.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDTO {

    private int accNo;
    private double accSaving;
    private String memberId;
    private String productId;
    private Date accSavingDate;
}
