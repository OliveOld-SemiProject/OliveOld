package com.semi.oliveold.detail.controller;

import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.detail.dto.ReviewDTO;
import com.semi.oliveold.detail.service.DetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping(value = "/findlist")
    public ModelAndView findProductListByNo(HttpServletRequest request, ModelAndView mv, @RequestParam int no){

        System.out.println("no ==========>" + no);

        List<DetailDTO> findProductListByNo = detailService.findProductListByNo(no);
        List<DetailDTO> findNewProductListByNo = detailService.findNewProductListByNo(no);
        List<ReviewDTO> findReviewListByProductNo = detailService.findReviewListByProductNo(no);


        log.info("[DetailController] findProductListByNo : " + findProductListByNo);
        log.info("[DetailController] findNewProductListByNo : " + findNewProductListByNo);
        log.info("[DetailController] findNewProductListByNo : " + findReviewListByProductNo);


//        mv.addObject("productList", productList.get(0));

        mv.addObject("findProductListByNo", findProductListByNo);
        mv.addObject("findNewProductListByNo", findNewProductListByNo);
        mv.addObject("findReviewListByProductNo", findReviewListByProductNo);

        mv.setViewName("product_detail");

        return mv;



    }

//    @GetMapping("/regist")
//    public String RegistReview() { return "/reviewRegist";}
//
//    @PostMapping("/regist")
//    public String registReview(@ModelAttribute ReviewDTO reviewDTO, RedirectAttributes rttr){
//
//        log.info("=================================================================");
//        log.info("[DetailController]  registReview : " + reviewDTO);
//
//        detailService.registReview(reviewDTO);
//
//        rttr.addFlashAttribute("message", "리뷰 등록 성공!!!");
//
//        return "redirect:/detail/findlist";
//
//    }








//    @GetMapping(value = "/findnewlist")
//    public ModelAndView findNewProductListByNo(HttpServletRequest request, ModelAndView mv, @RequestParam int no){
//
//        System.out.println("no ==========>" + no);
//
//        List<DetailDTO> findNewProductListByNo = detailService.findNewProductListByNo(no);
//
//        log.info("[DetailController] findNewProductListByNo : " + findNewProductListByNo);
//
////        mv.addObject("productList", productList.get(0));
//
//        mv.addObject("findNewProductListByNo", findNewProductListByNo);
//
//        mv.setViewName("product_detail");
//
//        return mv;
//
//
//    }


    @GetMapping(value = "/list")
    public ModelAndView productList(HttpServletRequest request, ModelAndView mv){



       List<DetailDTO> productList = detailService.selectProductList();


       log.info("[DetailController] productList : " + productList);

//        mv.addObject("productList", productList.get(0));

        mv.addObject("productList", productList);

        mv.setViewName("/product_detail");

        return mv;


    }


}
