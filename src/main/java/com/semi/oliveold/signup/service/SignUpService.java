package com.semi.oliveold.signup.service;

import com.semi.oliveold.faq.exception.FaqBoardRegistException;
import com.semi.oliveold.member.dto.MemberDTO;
import com.semi.oliveold.member.exception.MemberJoinException;
import com.semi.oliveold.member.repository.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SignUpService {

    MemberMapper memberMapper;

    public SignUpService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Transactional
    public void insertMember(MemberDTO member) throws MemberJoinException {

        if(memberMapper.insertMember(member) < 0) {
            throw new MemberJoinException("회원등록에 실패하였습니다.");
        }
    }
}
