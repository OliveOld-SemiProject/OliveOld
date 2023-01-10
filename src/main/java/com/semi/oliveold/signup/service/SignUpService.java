package com.semi.oliveold.signup.service;

import com.semi.oliveold.member.dto.MemberDTO;
import com.semi.oliveold.member.repository.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SignUpService {

    MemberMapper memberMapper;

    public SignUpService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public int insertMember(MemberDTO member){
        return memberMapper.insertMember(member);
    }
}
