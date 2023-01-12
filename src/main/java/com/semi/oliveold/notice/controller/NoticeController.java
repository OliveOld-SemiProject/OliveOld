package com.semi.oliveold.notice.controller;

import com.semi.oliveold.notice.dto.NoticeCriteria;
import com.semi.oliveold.notice.dto.NoticeDTO;
import com.semi.oliveold.notice.dto.NoticePagenation;
import com.semi.oliveold.notice.exception.NoticeRegistException;
import com.semi.oliveold.notice.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Slf4j
@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

//    @GetMapping
//    public String NoticePage(){
//        return "Notice";
//    }

    @GetMapping("/list")
    public ModelAndView noticeList(HttpServletRequest request,ModelAndView mv){

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        int totalCount = noticeService.selectTotalCount(searchMap);
        int limit = 10;
        int buttonAmount = 5;

        NoticeCriteria noticeCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {

            noticeCriteria = NoticePagenation.getNoticeCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);

        } else {
            noticeCriteria = NoticePagenation.getNoticeCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<NoticeDTO> noticeList = noticeService.selectNoticeList(noticeCriteria);


//        List<NoticeDTO> noticeList = noticeService.selectAllNoticeList();
//
        mv.addObject("noticeList", noticeList);
        mv.addObject("noticeCriteria", noticeCriteria);
        log.info("noticeList : "+ noticeList);
//
        mv.setViewName("/Notice");
//
        return mv;
    }

    @GetMapping("/regist")
    public String goRegister(){

        return "/notice/noticeRegist";
    }

    @PostMapping("/regist")
    public String registNotice(@ModelAttribute NoticeDTO notice, RedirectAttributes rttr) throws NoticeRegistException {

        noticeService.registNotice(notice);

        System.out.println("notice = " + notice);
        rttr.addFlashAttribute("message", "공지사항 등록에 성공하였습니다.");

        return "redirect:/notice/list";
    }

    @GetMapping("/detail")
    public String selectNoticeDetail(HttpServletRequest request, Model model){

        Long no = Long.valueOf(request.getParameter("no"));
        NoticeDTO noticeDetail = noticeService.selectNoticeDetail(no);

        log.info("noticeDetail : " + noticeDetail);

        model.addAttribute("noticeDetail", noticeDetail);

        return "notice/noticeDetail";
    }



}
