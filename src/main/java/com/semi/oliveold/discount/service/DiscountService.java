package com.semi.oliveold.discount.service;


import com.semi.oliveold.discount.repository.DiscountMapper;
import com.semi.oliveold.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    private final DiscountMapper mapper;


    public DiscountService(DiscountMapper mapper) {

        this.mapper = mapper;

    }

    public List<MemberDTO> selectMemberList() {

        List<MemberDTO> memberList = mapper.selectMemberList();

        return memberList;
    }

}
