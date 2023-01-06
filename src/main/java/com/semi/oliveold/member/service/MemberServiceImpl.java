package com.semi.oliveold.member.service;


import com.semi.oliveold.member.dto.AuthorityDTO;
import com.semi.oliveold.member.dto.MemberDTO;
import com.semi.oliveold.member.dto.MemberRoleDTO;
import com.semi.oliveold.member.dto.UserImpl;
import com.semi.oliveold.member.repository.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    /*
    * 사용자가 입력한 아이디를 토대로 해당 회원을 조회한 후
    *  UserDetails 객체 타입의 User객체를 만들어서 반환하는 용도의 메소드
    * */
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        log.info("");
        log.info("**MemberServiceImpl.loadUserByUsername**");

        /* 로그인 시 사용한 아이디를 가지고 데이터베이스에가서 사용자 정보를 조회 */
        MemberDTO member = memberMapper.findMemberById(memberId);

        /* 사용자가 입력한 아이디로 조회가 안될 경우 NPE(NullPointerException) 방지를 위해 빈 MemberDTO 객체 생성*/
        if(member == null){
            member = new MemberDTO();
        }

        // 권한 목록
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(member.getMemberRoleList() != null){

            List<MemberRoleDTO> roleList = member.getMemberRoleList();

            for(int i = 0; i < roleList.size(); i++){

                AuthorityDTO authority = roleList.get(i).getAuthority();
                authorities.add(new SimpleGrantedAuthority(authority.getName()));
            }
        }

        UserImpl user = new UserImpl(member.getMemberId(), member.getMemberPwd(), authorities);
        user.setDetails(member);

        return user;
    }
}
