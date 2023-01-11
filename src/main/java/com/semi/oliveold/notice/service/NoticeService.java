package com.semi.oliveold.notice.service;

import com.semi.oliveold.notice.dto.NoticeCriteria;
import com.semi.oliveold.notice.dto.NoticeDTO;
import com.semi.oliveold.notice.exception.NoticeRegistException;
import com.semi.oliveold.notice.repository.NoticeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeService {

    private final NoticeMapper mapper;

    public NoticeService(NoticeMapper mapper) {
        this.mapper = mapper;
    }


//    public List<NoticeDTO> selectAllNoticeList() {
//
//        List<NoticeDTO> noticeList = mapper.selectAllNoticeList();
//
//        return noticeList;
//    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    public List<NoticeDTO> selectNoticeList(NoticeCriteria noticeCriteria) {

        List<NoticeDTO> noticeList = mapper.selectNoticeList(noticeCriteria);

        return noticeList;
    }

    public void registNotice(NoticeDTO notice) {

        int result = mapper.insertNotice(notice);

    }
}
