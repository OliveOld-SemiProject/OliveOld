package com.semi.oliveold.oneonone.repository;


import com.semi.oliveold.faq.dto.AttachmentDTO;
import com.semi.oliveold.oneonone.dto.OneOnOneBoardDTO;
import com.semi.oliveold.oneonone.dto.OneOnOneSelectCriteriaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OneOnOneBoardMapper {
    List<OneOnOneBoardDTO> selectOneOnOneBoardList(OneOnOneSelectCriteriaDTO oneOnOneSelectCriteria);

    int selectTotalCount(Map<String, String> searchMap);

    int registOneOnOneBoard(OneOnOneBoardDTO board);

    int incrementBoardCount(Long no);

    OneOnOneBoardDTO selectBoardDetail(Long no);

    int removeOneOnOne(Long no);

    int modifyOneOnOne(OneOnOneBoardDTO oneOnOneBoard);

    int insertAttachment(AttachmentDTO attachmentDTO);
}
