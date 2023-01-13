package com.semi.oliveold.notice.repository;

import com.semi.oliveold.notice.dto.NoticeCriteria;
import com.semi.oliveold.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
//    List<NoticeDTO> selectAllNoticeList();

    int selectTotalCount(Map<String, String> searchMap);

    List<NoticeDTO> selectNoticeList(NoticeCriteria noticeCriteria);

    int registNotice(NoticeDTO notice);

    NoticeDTO selectNoticeDetail(Long no);

    int updateNotice(NoticeDTO notice);

    int removeNotice(Long no);

//    int incrementNoticeCount(Long no);
}
