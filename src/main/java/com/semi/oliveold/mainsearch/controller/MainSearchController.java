package com.semi.oliveold.mainsearch.controller;


import com.semi.oliveold.mainsearch.dto.SearchProductDTO;
import com.semi.oliveold.mainsearch.dto.SearchProductPagenation;
import com.semi.oliveold.mainsearch.dto.SearchProductSelectCriteriaDTO;
import com.semi.oliveold.mainsearch.service.MainSearchService;
import com.semi.oliveold.oneonone.dto.OneOnOneBoardDTO;
import com.semi.oliveold.oneonone.dto.OneOnOnePagenation;
import com.semi.oliveold.oneonone.dto.OneOnOneSelectCriteriaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/mainSearch")
public class MainSearchController {

    private final MainSearchService mainSearchService;

    public MainSearchController(MainSearchService mainSearchService) {
        this.mainSearchService = mainSearchService;
    }


    @GetMapping(value = "/search")
    public ModelAndView searchProductList(HttpServletRequest request, ModelAndView mv) {

        log.info("");
        log.info("");
        log.info("MainSearchController start");

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);


        log.info("[MainSearchController] 컨트롤에서 검색 조건 확인하기" + searchMap);

        int totalCount = mainSearchService.selectTotalCount(searchMap);
        log.info("[MainSearchController] MainSearch Count" + totalCount);
        int limit = 5;                 //게시물 최대 갯수
        int buttonAmount = 1;           //버튼 갯수

        SearchProductSelectCriteriaDTO searchProductSelectCriteria = null;

        if (searchValue != null && !"".equals(searchValue)) {
            searchProductSelectCriteria = SearchProductPagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            searchProductSelectCriteria = SearchProductPagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[MainSearchController] searchProductSelectCriteria" + searchProductSelectCriteria);

        //리스트 객체
        List<SearchProductDTO> searchProductList = mainSearchService.selectSearchProductList(searchProductSelectCriteria);

        log.info("MainSearchController searchProductList : " + searchProductList);


        mv.addObject("searchProductList", searchProductList);
        mv.addObject("searchProductSelectCriteria", searchProductSelectCriteria);

        mv.setViewName("searchResults");

        log.info("MainSearchController over");

        return mv;


    }

}
