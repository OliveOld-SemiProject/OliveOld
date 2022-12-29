package com.semi.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    public String memberId;
    public String memberPwd;
    public String memberName;
    public String memberGender;
    public String memberIdentifier;
    public String memberPhone;
    public String memberAddress;
    public String memberEmail;
    public Date memberRegistDate;
    public String memberISAD;
    public String memberLevel;
    public String memberType;


}
