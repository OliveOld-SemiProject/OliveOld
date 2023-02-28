package com.semi.oliveold.order.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderMemberDTO {

    public String memberId; // 아이디

    public String memberPwd; // 비밀번호

    public String memberName; // 이름
    public String memberGender; // 성별
    public String memberIdentifier; // 주민번호

    public String memberPhone; // 전화번호
    public String Phone1; // 010
    public String Phone2; // 가운데 4자리
    public String Phone3; // 마지막 4자리

    public String memberAddress; // 주소
    public String zipcode; // 우편번호
    public String address1; // 도로명/지번 주소
    public String address2; // 상세주소

    public String memberEmail; // 이메일

    public Date memberRegistDate; // 등록 일자

    public String memberISAD; // 동의 여부
    public String memberLevel; // 등급
    public String memberType; // 관리자/고객

    public int mileage; // 적립금

}
