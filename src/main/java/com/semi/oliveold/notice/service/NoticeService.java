package com.semi.oliveold.notice.service;

import com.semi.oliveold.notice.dto.NoticeDTO;
import com.semi.oliveold.notice.repository.NoticeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeService {

    private final NoticeMapper mapper;

    public NoticeService(NoticeMapper mapper) {
        this.mapper = mapper;
    }


    public List<NoticeDTO> selectAllNoticeList() {

        List<NoticeDTO> noticeList = mapper.selectAllNoticeList();

        return noticeList;
    }

}
