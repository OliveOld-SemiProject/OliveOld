package com.semi.oliveold.oneonone.controller;


import com.semi.oliveold.faq.dto.AttachmentDTO;
import com.semi.oliveold.faq.exception.FaqBoardRegistException;
import com.semi.oliveold.oneonone.dto.OneOnOneBoardDTO;
import com.semi.oliveold.oneonone.dto.OneOnOnePagenation;
import com.semi.oliveold.oneonone.dto.OneOnOneSelectCriteriaDTO;
import com.semi.oliveold.oneonone.exception.OneOnOneModifyException;
import com.semi.oliveold.oneonone.exception.OneOnOneRegistException;
import com.semi.oliveold.oneonone.exception.OneOnOneRemoveException;
import com.semi.oliveold.oneonone.service.OneOnOneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/OneOnOneBoard")
public class OneOnOneController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final OneOnOneService oneOnOneService;

    public OneOnOneController(OneOnOneService oneOnOneService){

        this.oneOnOneService = oneOnOneService;
    }

    @GetMapping(value = "/list")
    public ModelAndView faqBoardList(@AuthenticationPrincipal User user, HttpServletRequest request, ModelAndView mv){

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


        log.info("String typeValue ======" + typeValue);



        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("type", typeValue);



        log.info("[OneOnOneController] ??????????????? ?????? ?????? ????????????" + searchMap);

        int totalCount = oneOnOneService.selectTotalCount(searchMap);
        log.info("[oneOnOneService] totalOneOnOneBoardCount" + totalCount);
        int limit = 5;                 //1:1?????? ????????? ?????? ??????
        int buttonAmount = 1;           //?????? ??????

        OneOnOneSelectCriteriaDTO oneOnOneSelectCriteria = null;

        if(typeValue !=null && !"".equals(typeValue)){
            oneOnOneSelectCriteria = OneOnOnePagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue,typeValue);
        } else {
            oneOnOneSelectCriteria = OneOnOnePagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[OneOnOneController] OneOnOneselectCriteria" + oneOnOneSelectCriteria);


        List<OneOnOneBoardDTO> oneOnOneBoardList = oneOnOneService.selectOneOnOneBoardList(oneOnOneSelectCriteria);

        log.info("OneOnOneController OneOnOneBoardList : " + oneOnOneBoardList);



        mv.addObject("oneOnOneBoardList", oneOnOneBoardList);
        mv.addObject("oneOnOneSelectCriteria", oneOnOneSelectCriteria);
        mv.addObject("type", typeValue);
        mv.setViewName("oneonone/One-on-one-Inquiry");

        log.info("OneOnOneController over");

        return mv;
    }


    //OneOnOne ??????
    @GetMapping("/regist")
    public String goRegister(){
        return "oneonone/OneOnOneBoardRegist";
    }

    @PostMapping("/regist")
    public String registFaqBoard(@ModelAttribute OneOnOneBoardDTO board,HttpServletRequest request,
                                 @RequestParam(required=false) MultipartFile multipartFiles,
                                 RedirectAttributes rttr) throws FaqBoardRegistException, OneOnOneRegistException {

//        String multiFileDescription = request.getParameter("multiFileDescription");
        System.out.println("multiFiles : " + multipartFiles);
//        System.out.println("multiFileDescription : " + multiFileDescription);

        String root = request.getSession().getServletContext().getRealPath("resources");

        System.out.println("root : " + root);


        String filePath = root + "\\uploadFiles";

        File mkdir = new File(filePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        /* ????????? ?????? ?????? */
        String originFileName = multipartFiles.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;


        /* ????????? ?????? ?????? ?????? ??? ?????? */
        Map<String, String> file = new HashMap<>();
        file.put("originFileName", originFileName);
        file.put("savedName", savedName);
        file.put("filePath", filePath);


        // service?????? ?????????????????? ????????? ???????????? ?????? ??????
        AttachmentDTO tempFileInfo = new AttachmentDTO();
        tempFileInfo.setRefBoardNo(board.getNo());
        tempFileInfo.setOriginalName(file.get("originFileName"));
        tempFileInfo.setSavedName(file.get("savedName"));
        tempFileInfo.setSavePath(file.get("filePath"));



        board.setAttachment(tempFileInfo);

        System.out.println("tempFileInfo" +   tempFileInfo);

        try {

              // ??? ???????????? ?????? ???????????? ??????
              multipartFiles.transferTo(new File(filePath + "\\" + file.get("savedName")));

        } catch (IllegalStateException | IOException e) {

            e.printStackTrace();
            /* ????????? ?????? ?????? */
            new File(filePath + "\\" + file.get("savedName")).delete();
        }

        System.out.println("files : " + file);


        log.info("");
        log.info("");
        log.info("[OneOnOneBoard Controller] OneOnOneBoard =========================================================");
        // board????????? ????????? ?????? + ??????????????? ?????? ?????? ???????????? ????????????.
        log.info("[OneOnOneBoard Controller] OneOnOneBoard Request : " + board);

        oneOnOneService.registOneOnOneBoard(board);

        rttr.addFlashAttribute("message", "1:1 ???????????? ????????????");

        log.info("[OneOnOneBoard Controller] OneOnOneBoard =========================================================");
        System.out.println("original name : "  +board.getAttachment().getOriginalName());

        return "redirect:/OneOnOneBoard/list";
    }

    
    //????????? ?????? ?????? ????????????
    @GetMapping("/detail")
    public String selectBoardDetail(HttpServletRequest request, Model model){

        log.info("");
        log.info("");
        log.info("[OneOnOneBoard Controller] OneOnOneBoard Detail =========================================================");

        Long no = Long.valueOf(request.getParameter("no"));
        OneOnOneBoardDTO oneOnOneDetail = oneOnOneService.selectBoardDetail(no);

        log.info("[OneOnOneBoard Controller] OneOnOneBoard Detail : " + oneOnOneDetail);

        model.addAttribute("oneOnOneDetail", oneOnOneDetail);

        log.info("[OneOnOneBoard Controller] ============");


        return "oneonone/OneOnOneboardDetail";
    }

    //??????


    @GetMapping("/update")
    public String goModifyNotice(HttpServletRequest request, Model model) {

        log.info("");
        log.info("");
        log.info("[modifyNoticeController] modify =========================================================");

        Long no = Long.valueOf(request.getParameter("no"));

        OneOnOneBoardDTO oneOnOneBoard = oneOnOneService.selectBoardDetail(no);

        model.addAttribute("oneOnOneBoard", oneOnOneBoard);

        log.info("[modifyNoticeController] modify =========================================================");

        return "oneonone/OneOnOneUpdate";
    }


    @PostMapping("/update")
    public String modifyNotice(@ModelAttribute OneOnOneBoardDTO oneOnOneBoard, RedirectAttributes rttr) throws OneOnOneModifyException {

        log.info("");
        log.info("");
        log.info("[modifyNoticeController] modify =========================================================");

        log.info("[NoticeController] notice : "+ oneOnOneBoard);
        oneOnOneService.modifyOneOnOne(oneOnOneBoard);


        rttr.addFlashAttribute("message", "????????? ?????????????????????!");

        log.info("[modifyNoticeController] modify  =========================================================");
        return "redirect:/OneOnOneBoard/list";
    }





    //??????
    @GetMapping("/delete")
    public String removeNotice(HttpServletRequest request, RedirectAttributes rttr) throws OneOnOneRemoveException {

        Long no = Long.valueOf(request.getParameter("no"));

        oneOnOneService.removeOneOnOne(no);

        rttr.addFlashAttribute("message", "????????? ?????????????????????!");

        return "redirect:/OneOnOneBoard/list";
    }

    @GetMapping("/deleteBoardFile")
    public String deleteBoardFile(@RequestParam int no) throws Exception{
        oneOnOneService.deleteBoardFile(no);
        System.out.println("no =========" + no);
        return "redirect:/OneOnOneBoard/detail?no="+no;
    }


    // ?????? ?????????









    //????????? ????????? ????????????

    //??????
//    @GetMapping("/index.html")
//    public String goindex(){
//        return "redirect:/";
//    }

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
        return "redirect:/notice/list";
    }


}
