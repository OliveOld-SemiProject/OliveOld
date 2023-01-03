package com.semi.discount.repository;

import com.semi.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiscountMapper {

    List<MemberDTO> selectMemberList();
}
