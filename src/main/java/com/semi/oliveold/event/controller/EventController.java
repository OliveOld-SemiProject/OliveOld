package com.semi.oliveold.event.controller;


import com.semi.oliveold.event.dto.EventDTO;
import com.semi.oliveold.event.service.EventService;


import com.semi.oliveold.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/lists")
    public ModelAndView memberList(HttpServletRequest request, ModelAndView mv){

        List<MemberDTO> memberList = eventService.selectMemberList();

        mv.addObject("memberList", memberList);
        mv.setViewName("");
        log.info("memberList " + memberList);

        return mv;
    }

    @GetMapping("/")
    public ModelAndView MileageList(/*Principal principal,*/ ModelAndView mv){

//        String longId = principal.getName();

        List<EventDTO> eventList = eventService.MileageList();
        mv.addObject("EventList", eventList);
        mv.setViewName("/myPage");

        log.info("eventList" + eventList);

        return mv;
    }

    @GetMapping("/roulette")
    public String goInsertMileage(){
        return "/rouletteEvent";
    }
    @PostMapping("/roulette")
    public String insertMileage(@ModelAttribute EventDTO event) throws Exception {

        eventService.insertMileage(event);

        return "redirect:";


    }


//    @RequestMapping(value = "/rouletteEvent", method = RequestMethod.POST)
//    public String modifyMileage(@RequestBody EventDTO eventDTO) throws Exception {
//
//
//        eventService.modifyMileage(eventDTO);
//
//        return "/rouletteEvent";
//
//    }

}
