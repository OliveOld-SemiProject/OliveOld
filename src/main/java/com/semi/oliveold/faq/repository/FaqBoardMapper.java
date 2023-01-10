package com.semi.oliveold.faq.repository;

import com.semi.oliveold.faq.dto.BoardDTO;
import com.semi.oliveold.faq.dto.SelectCriteriaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FaqBoardMapper {

    int selectTotalCount(Map<String, String> searchMap);

    List<BoardDTO> selectFaqBoardList(SelectCriteriaDTO selectCriteria);

    int insertFaqBoard(BoardDTO board);

    BoardDTO selectfaqBoardDetail(Long no);

    int modifyfaqBoard(BoardDTO board);

    int removefaqBoard(Long no);
}
