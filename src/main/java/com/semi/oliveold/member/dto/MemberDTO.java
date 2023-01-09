package com.semi.oliveold.member.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {


    private String memberId;
    private String memberPwd;
    private String memberName;
    private String memberGender;
    private String memberIdentifier;
    private String memberPhone;
    private String memberAddress;
    private String memberEmail;
    private Date memberRegistDate;
    private String memberISAD;
    private String memberLevel;
    private String memberType;


}
