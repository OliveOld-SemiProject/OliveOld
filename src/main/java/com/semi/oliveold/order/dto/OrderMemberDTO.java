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
    public String Phone1;
    public String Phone2;
    public String Phone3;

    public String memberAddress;
    public String zipcode;
    public String address1;
    public String address2;

    public String memberEmail;
    public Date memberRegistDate;
    public String memberISAD;
    public String memberLevel;
    public String memberType;

    public int mileage;

}
