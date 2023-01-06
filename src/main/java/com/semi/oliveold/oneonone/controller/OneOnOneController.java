package com.semi.oliveold.oneonone.controller;


import com.semi.oliveold.faq.exception.FaqBoardRegistException;
import com.semi.oliveold.oneonone.dto.OneOnOneBoardDTO;
import com.semi.oliveold.oneonone.dto.OneOnOnePagenation;
import com.semi.oliveold.oneonone.dto.OneOnOneSelectCriteriaDTO;
import com.semi.oliveold.oneonone.exception.OneOnOneRegistException;
import com.semi.oliveold.oneonone.service.OneOnOneService;
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


@Controller
@RequestMapping("/OneOnOneBoard")
public class OneOnOneController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final OneOnOneService oneOnOneService;

    public OneOnOneController(OneOnOneService oneOnOneService){

        this.oneOnOneService = oneOnOneService;
    }

    @GetMapping(value = "/list")
    public ModelAndView faqBoardList(HttpServletRequest request, ModelAndView mv){

        log.info("");
        log.info("");
        log.info("OneOnOneController start");
        log.info("type ======================== " + request.getParameter("type"));

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)){
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");
        String typeValue = request.getParameter("type");



        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("type", typeValue);



        log.info("[OneOnOneController] 컨트롤에서 검색 조건 확인하기" + searchMap);

        int totalCount = oneOnOneService.selectTotalCount(searchMap);
        log.info("[oneOnOneService] totalOneOnOneBoardCount" + totalCount);
        int limit = 10;                 //1:1문의 게시물 최대 갯수
        int buttonAmount = 0;           //버튼 갯수

        OneOnOneSelectCriteriaDTO oneOnOneSelectCriteria = null;

        if(searchCondition !=null && !"".equals(searchCondition)){
            oneOnOneSelectCriteria = OneOnOnePagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue,typeValue);
        } else {
            oneOnOneSelectCriteria = OneOnOnePagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[OneOnOneController] OneOnOneselectCriteria" + oneOnOneSelectCriteria);


        List<OneOnOneBoardDTO> oneOnOneBoardList = oneOnOneService.selectOneOnOneBoardList(oneOnOneSelectCriteria);

        log.info("OneOnOneController OneOnOneBoardList : " + oneOnOneBoardList);

        mv.addObject("oneOnOneBoardList", oneOnOneBoardList);
        mv.addObject("oneOnOneSelectCriteria", oneOnOneSelectCriteria);

        mv.setViewName("oneonone/One-on-one-Inquiry");

        log.info("OneOnOneController over");

        return mv;
    }


    //OneOnOne 등록
    @GetMapping("/regist")
    public String goRegister(){
        return "oneonone/OneOnOneBoardRegist";
    }

    @PostMapping("/regist")
    public String registFaqBoard(@ModelAttribute OneOnOneBoardDTO board, RedirectAttributes rttr) throws FaqBoardRegistException, OneOnOneRegistException {

        log.info("");
        log.info("");
        log.info("[OneOnOneBoard Controller] OneOnOneBoard =========================================================");
        log.info("[OneOnOneBoard Controller] OneOnOneBoard Request : " + board);

        oneOnOneService.registOneOnOneBoard(board);

        rttr.addFlashAttribute("message", "1:1 문의사항 등록완료");

        log.info("[OneOnOneBoard Controller] OneOnOneBoard =========================================================");

        return "redirect:/OneOnOneBoard/list";
    }








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


}
