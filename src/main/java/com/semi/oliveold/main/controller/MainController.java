package com.semi.oliveold.main.controller;


import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.main.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {this.mainService = mainService; }


//    @GetMapping
//    public ModelAndView newProductList(HttpServletRequest request, ModelAndView mv){
//
//        List<DetailDTO> newProductList = mainService.selectNewProductList();
//
//        log.info("[MainController] newProductList : " + newProductList);
//
////        mv.addObject("productList", productList.get(0));
//
//        mv.addObject("newProductList", newProductList);
//
//
//        mv.setViewName("/index");
//
//        return mv;
//
//
//    }

    @GetMapping
    public ModelAndView productList(HttpServletRequest request, ModelAndView mv){

        List<DetailDTO> productList = mainService.selectProductList();
        List<DetailDTO> newProductList = mainService.selectNewProductList();

        log.info("[MainController] productList : " + productList);
        log.info("[MainController] newProductList : " + newProductList);

//        mv.addObject("productList", productList.get(0));

        mv.addObject("productList", productList);
        mv.addObject("newProductList", newProductList);


        mv.setViewName("/index");

        return mv;
    }

    @PostMapping
    public ModelAndView productList2(HttpServletRequest request, ModelAndView mv){

        List<DetailDTO> productList = mainService.selectProductList();

        log.info("[MainController] productList : " + productList);

//        mv.addObject("productList", productList.get(0));

        mv.addObject("productList", productList);


        mv.setViewName("/index");

        return mv;
    }






}
