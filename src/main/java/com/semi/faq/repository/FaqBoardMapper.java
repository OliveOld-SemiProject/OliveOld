package com.semi.faq.repository;

import com.semi.faq.dto.BoardDTO;
import com.semi.faq.dto.SelectCriteriaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FaqBoardMapper {

    int selectTotalCount(Map<String, String> searchMap);

    List<BoardDTO> selectFaqBoardList();
}
