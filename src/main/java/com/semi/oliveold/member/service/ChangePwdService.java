package com.semi.oliveold.member.service;

import com.semi.oliveold.member.dto.MemberDTO;
import com.semi.oliveold.member.exception.MemberJoinException;
import com.semi.oliveold.member.repository.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class ChangePwdService {

    MemberMapper memberMapper;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public ChangePwdService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Transactional
    public void changePwd(String memberId, String oldPwd, String newPwd) throws MemberJoinException {

        MemberDTO member = memberMapper.findMemberById(memberId);

        if(!(encoder.matches(oldPwd, member.getMemberPwd()))){
            throw new MemberJoinException("이전 패스워드가 일치하지 않습니다.");
        }

        log.info("**패스워드가 일치합니다.**");

        String encoderNewPwd = encoder.encode(newPwd);

        memberMapper.changePwd(memberId, encoderNewPwd);

    }
}
