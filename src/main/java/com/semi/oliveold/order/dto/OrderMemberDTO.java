package com.semi.oliveold.order.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderMemberDTO {


    public String memberId;
    public String memberPwd;
    public String memberName;
    public String memberGender;
    public String memberIdentifier;
    public String memberPhone;
    public String memberPhone1;
    public String memberPhone2;
    public String memberPhone3;
    public String memberAddress;
    public String memberEmail;
    public Date memberRegistDate;
    public String memberISAD;
    public String memberLevel;
    public String memberType;

    public int mileage;

}
