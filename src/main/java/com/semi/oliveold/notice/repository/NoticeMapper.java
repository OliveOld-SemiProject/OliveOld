package com.semi.oliveold.notice.repository;

import com.semi.oliveold.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> selectAllNoticeList();


}
