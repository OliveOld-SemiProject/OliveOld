package com.semi.oliveold.member.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class UserImpl extends User {

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

    private List<MemberRoleDTO> memberRoleList;

    public UserImpl(String memberId, String memberPwd, Collection<? extends GrantedAuthority> authorities) {
        super(memberId, memberPwd, authorities);
    }


    public void setDetails(MemberDTO member){

        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberIdentifier = memberIdentifier;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
        this.memberEmail = memberEmail;
        this.memberRegistDate = memberRegistDate;
        this.memberISAD = memberISAD;
        this.memberLevel = memberLevel;
        this.memberType = memberType;
        this.memberRoleList = memberRoleList;

    }


}




