package com.semi.oliveold.member.repository;

import com.semi.oliveold.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    MemberDTO findMemberById(String memberId);

    int insertMember(MemberDTO member);
}
