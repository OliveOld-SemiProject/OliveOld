package com.semi.oliveold.notice.service;

import com.semi.oliveold.notice.dto.NoticeCriteria;
import com.semi.oliveold.notice.dto.NoticeDTO;
import com.semi.oliveold.notice.exception.NoticeModifyException;
import com.semi.oliveold.notice.exception.NoticeRegistException;
import com.semi.oliveold.notice.exception.NoticeRemoveException;
import com.semi.oliveold.notice.repository.NoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void registNotice(NoticeDTO notice) throws NoticeRegistException {

        int result = mapper.registNotice(notice);

        if(!(result > 0 )){
            throw new NoticeRegistException("공지사항 등록에 실패하셨습니다.");

        }
    }

    /* 상세 페이지 조회용 */
    public NoticeDTO selectNoticeDetail(Long no) {

        NoticeDTO noticeDetail = null;

//        int result = mapper.incrementNoticeCount(no);

//        if(result > 0) {
            noticeDetail = mapper.selectNoticeDetail(no);
//        }
        return noticeDetail;
    }

    public void modifyNotice(NoticeDTO notice) throws NoticeModifyException {

        int result = mapper.updateNotice(notice);

        if(!(result > 0)){
            throw new NoticeModifyException("공지사항 수정에 실패하셨습니다.");
        }
    }

//    삭제용 메소드
    public void removeNotice(Long no) throws NoticeRemoveException {

        int result = mapper.removeNotice(no);

        if(!(result > 0)){

            throw new NoticeRemoveException("공지사항 삭제에 실패하셨습니다.");
        }
    }
}
