package com.semi.oliveold.event.repository;

import com.semi.oliveold.event.dto.EventDTO;
import com.semi.oliveold.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {


    List<MemberDTO> selectMemberList();




    int UpdateMileage(MemberDTO member);
}



