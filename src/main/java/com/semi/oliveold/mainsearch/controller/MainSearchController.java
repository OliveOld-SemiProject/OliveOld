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
        String cateCode = request.getParameter("cateCode");


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("cateCode", cateCode);


        log.info("=============================cateCode  :  " + cateCode);


        log.info("[MainSearchController] 컨트롤에서 검색 조건 확인하기" + searchMap);

        int totalCount = mainSearchService.selectTotalCount(searchMap);
        log.info("[MainSearchController] MainSearch Count" + totalCount);
        int limit = 2;                 //게시물 최대 갯수
        int buttonAmount = 3;           //버튼 갯수


        SearchProductSelectCriteriaDTO searchProductSelectCriteria = null;

        if (searchValue != null && !"".equals(searchValue)) {
            searchProductSelectCriteria = SearchProductPagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, cateCode);
        } else if(cateCode != null && !"".equals(cateCode)) {
            searchProductSelectCriteria = SearchProductPagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, cateCode);
        }  else {
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


    //상단바 페이지 이동부분

    //로고
    @GetMapping("/index.html")
    public String goindex(){
        return "/index.html";
    }

    //로그인
    @GetMapping("/login.html")
    public String goLogin(){
        return "redirect:/login.html";
    }

    //회원가입
    @GetMapping("/signup.html")
    public String goSignUp(){
        return "redirect:/signup.html";
    }

    //주문배송
    @GetMapping("/order-delivery.html")
    public String goOrderList(){
        return "redirect:/order/list";
    }

    //쇼핑카드
    @GetMapping("/shoppingCart.html")
    public String goShoppingCart(){
        return "redirect:/cartList";
    }

    //공지사항
    @GetMapping("/Notice.html")
    public String goNotice(){
        return "redirect:/Notice.html";
    }

    //공지사항
    @GetMapping("/rouletteEvent.html")
    public String goRoulet(){
        return "redirect:/rouletteEvent.html";
    }






}
