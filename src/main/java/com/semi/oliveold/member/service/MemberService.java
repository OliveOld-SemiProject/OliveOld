package com.semi.oliveold.member.service;

import com.semi.oliveold.member.repository.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

}
