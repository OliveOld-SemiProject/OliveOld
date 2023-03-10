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


        log.info("[MainSearchController] ??????????????? ?????? ?????? ????????????" + searchMap);

        int totalCount = mainSearchService.selectTotalCount(searchMap);
        log.info("[MainSearchController] MainSearch Count" + totalCount);
        int limit = 2;                 //????????? ?????? ??????
        int buttonAmount = 3;           //?????? ??????


        SearchProductSelectCriteriaDTO searchProductSelectCriteria = null;

        if (searchValue != null && !"".equals(searchValue)) {
            searchProductSelectCriteria = SearchProductPagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, cateCode);
        } else if(cateCode != null && !"".equals(cateCode)) {
            searchProductSelectCriteria = SearchProductPagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, cateCode);
        }  else {
            searchProductSelectCriteria = SearchProductPagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }


        log.info("[MainSearchController] searchProductSelectCriteria" + searchProductSelectCriteria);

        //????????? ??????
        List<SearchProductDTO> searchProductList = mainSearchService.selectSearchProductList(searchProductSelectCriteria);

        log.info("MainSearchController searchProductList : " + searchProductList);


        mv.addObject("searchProductList", searchProductList);
        mv.addObject("searchProductSelectCriteria", searchProductSelectCriteria);

        mv.setViewName("searchResults");

        log.info("MainSearchController over");

        return mv;


    }


    //????????? ????????? ????????????

    //??????
    @GetMapping("/index.html")
    public String goindex(){
        return "/index.html";
    }

    //?????????
    @GetMapping("/login.html")
    public String goLogin(){
        return "redirect:/login.html";
    }

    //????????????
    @GetMapping("/signup.html")
    public String goSignUp(){
        return "redirect:/signup.html";
    }

    //????????????
    @GetMapping("/order-delivery.html")
    public String goOrderList(){
        return "redirect:/order/list";
    }

    //????????????
    @GetMapping("/shoppingCart.html")
    public String goShoppingCart(){
        return "redirect:/cartList";
    }

    //????????????
    @GetMapping("/Notice.html")
    public String goNotice(){
        return "redirect:/Notice.html";
    }

    //????????????
    @GetMapping("/rouletteEvent.html")
    public String goRoulet(){
        return "redirect:/rouletteEvent.html";
    }






}
