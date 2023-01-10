package com.semi.oliveold.notice.controller;

import com.semi.oliveold.notice.dto.NoticeDTO;
import com.semi.oliveold.notice.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

//    @GetMapping
//    public String NoticePage(){
//        return "Notice";
//    }

    @GetMapping("list")
    public ModelAndView noticeList(ModelAndView mv){

        List<NoticeDTO> noticeList = noticeService.selectAllNoticeList();

        mv.addObject("noticeList", noticeList);

        log.info("noticeList : "+ noticeList);

        mv.setViewName("/Notice");

        return mv;
    }

}
