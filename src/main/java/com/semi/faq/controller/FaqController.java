package com.semi.faq.controller;


import com.semi.faq.dto.BoardDTO;
import com.semi.faq.dto.Pagenation;
import com.semi.faq.dto.SelectCriteriaDTO;
import com.semi.faq.service.FaqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/faqBoard")
public class FaqController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final FaqService faqService;

    public FaqController(FaqService faqService){

        this.faqService = faqService;
    }

    @GetMapping(value = "/list")
    public ModelAndView faqBoardList(HttpServletRequest request, ModelAndView mv){

        log.info("");
        log.info("");
        log.info("faqController start");

        List<BoardDTO> faqBoardList = faqService.selectFaqBoardList();

        log.info("faqController faqBoardList : " + faqBoardList);

        mv.addObject("faqBoardList", faqBoardList);

        mv.setViewName("/FAQ");

        log.info("FaqController over");

        return mv;
    }


}
