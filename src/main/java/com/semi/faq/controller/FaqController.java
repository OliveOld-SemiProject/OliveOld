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

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)){
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition",searchCondition);
        searchMap.put("searchValue",searchValue);

        log.info("FaqController 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        int totalCount = faqService.selectTotalCount(searchMap);
        log.info("faqBoardController totalBoardCount :" +totalCount);

        int limit = 10;

        int buttonAmount = 5;

        SelectCriteriaDTO selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)){
            selectCriteria = Pagenation.getSelectCriteria(pageNo,totalCount,limit,buttonAmount,searchCondition,searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit , buttonAmount);
        }

        log.info("faqController selectCriteria : " + selectCriteria);

        List<BoardDTO> faqBoardList = faqService.selectFaqBoardList(selectCriteria);

        log.info("faqController faqBoardList : " + faqBoardList);

        mv.addObject("faqBoardList", faqBoardList);
        mv.addObject("selectCriteria", selectCriteria);

        log.info("FaqBoardController selectCriteria : " + selectCriteria);

        mv.setViewName("static/FAQ");

        log.info("FaqController over");

        return mv;
    }


}
