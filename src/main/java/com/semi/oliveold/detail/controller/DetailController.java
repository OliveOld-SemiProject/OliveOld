package com.semi.oliveold.detail.controller;

import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.detail.service.DetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/detail")
public class DetailController {

    private final DetailService detailService;

    public DetailController(DetailService detailService) {this.detailService = detailService; }


    @GetMapping(value = "/select")
    public ModelAndView selectProduct(HttpServletRequest request, ModelAndView mv) {

        DetailDTO selectProduct = detailService.selectProduct();

        log.info("[DetailController] selectProduct : " + selectProduct);

        mv.addObject("selectProduct", selectProduct);

        mv.setViewName("/product_detail");

        return mv;

    }


    @GetMapping(value = "list")
    public ModelAndView productList(HttpServletRequest request, ModelAndView mv){

        List<DetailDTO> productList = detailService.selectProductList();

        log.info("[DetailController] productList : " + productList);

        mv.addObject("productList", productList);

        mv.setViewName("/product_detail");

        return mv;


    }


}
