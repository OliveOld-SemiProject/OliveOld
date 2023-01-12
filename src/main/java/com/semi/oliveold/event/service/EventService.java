package com.semi.oliveold.event.service;

import com.semi.oliveold.event.dto.EventDTO;
import com.semi.oliveold.event.repository.EventMapper;
import com.semi.oliveold.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventMapper eventMapper;

    public EventService(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    public List<MemberDTO> selectMemberList() {

        List<MemberDTO> memberList = eventMapper.selectMemberList();

        return memberList;
    }





//    public void insertMileage(EventDTO event) {
//
//        int result = eventMapper.insertMileage();
//    }

    public void UpdateMileage(MemberDTO member) {

        eventMapper.UpdateMileage(member);


    }
}
