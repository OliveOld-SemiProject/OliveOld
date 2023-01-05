package com.semi.oliveold.faq.controller;


import com.semi.oliveold.faq.dto.BoardDTO;
import com.semi.oliveold.faq.dto.Pagenation;
import com.semi.oliveold.faq.dto.SelectCriteriaDTO;
import com.semi.oliveold.faq.exception.FaqBoardRegistException;
import com.semi.oliveold.faq.service.FaqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//FAQ 조회
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
        // 검색할 값
//        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");
        System.out.println("searchValue = " + searchValue);
        Map<String, String> searchMap = new HashMap<>();
//        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[FaqController] 컨트롤에서 검색 조건 확인하기" + searchMap);

        int totalCount = faqService.selectTotalCount(searchMap);
        log.info("[FaqController] totalFaqBoardCount" + totalCount);
        int limit = 10;
        int buttonAmount = 5;

        SelectCriteriaDTO selectCriteria = null;

        if(searchValue !=null && !"".equals(searchValue)){
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, null, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[FaqController] selectCriteria" + selectCriteria);


        List<BoardDTO> faqBoardList = faqService.selectFaqBoardList(selectCriteria);

        log.info("faqController faqBoardList : " + faqBoardList);

        mv.addObject("faqBoardList", faqBoardList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("/faq/FAQ");

        log.info("FaqController over");

        return mv;
    }




    //FAQ등록
    @GetMapping("/regist")
    public String goRegister(){
        return "faqBoardRegist";
    }

    @PostMapping("/regist")
    public String registFaqBoard(@ModelAttribute BoardDTO board, RedirectAttributes rttr) throws FaqBoardRegistException{

        log.info("");
        log.info("");
        log.info("[RegistFaqBoard Controller] faqRegistBoard =========================================================");
        log.info("[RegistFaqBoard Controller] faqRegistBoard Request : " + board);

        faqService.registFaqBoard(board);

        rttr.addFlashAttribute("message", "FAQ 공지사항 등록완료");

        log.info("[RegistFaqBoard Controller] faqRegistBoard =========================================================");

        return "redirect:/faqBoard/list";
    }


    //faq 삭제 부분







//상단바 페이지 이동부분

    //로고
    @GetMapping("/index.html")
    public String goindex(){
        return "redirect:/index.html";
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

    //










}
