package com.semi.oliveold.event.controller;


import com.semi.oliveold.event.dto.EventDTO;
import com.semi.oliveold.event.service.EventService;
import com.semi.oliveold.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
//    @GetMapping("/game")
//    public ModelAndView memberList(@AuthenticationPrincipal User user, HttpServletRequest request, ModelAndView mv){
//
//        user.getUsername();
//        List<MemberDTO> memberList = eventService.selectMemberList();
//
//        mv.addObject("memberList", memberList);
//        mv.setViewName("/myPage");
//        log.info("memberList " + memberList);


//        return mv;
//    }

//    @GetMapping("/list")
//    public ModelAndView MileageList(/*Principal principal,*/ ModelAndView mv){
//
////        String longId = principal.getName();
//
//        List<EventDTO> eventList = eventService.MileageList();
//        mv.addObject("EventList", eventList);
//        mv.setViewName("/myPage");
//
//        log.info("eventList" + eventList);
//
//        return mv;
//    }
    @GetMapping("/game")
    public String goRoulette(){
        return "/rouletteEvent";
    }

    @GetMapping("/update")
    public String UpdateMileage(){
        return "/rouletteEvent";
    }
    @PostMapping("/update")
    public String UpdateMileage(@AuthenticationPrincipal User user, @ModelAttribute MemberDTO member) throws Exception {

        user.getUsername();

        eventService.UpdateMileage(member);

        return "/rouletteEvent";


    }



}
