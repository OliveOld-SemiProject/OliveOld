package com.semi.oliveold.notice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeController {

    @GetMapping
    public String NoticePage(){
        return "Notice";
    }
}
