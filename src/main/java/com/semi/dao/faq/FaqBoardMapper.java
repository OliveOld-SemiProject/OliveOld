package com.semi.dao.faq;

import com.semi.dto.Board.BoardDTO;
import com.semi.dto.Board.SelectCriteriaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FaqBoardMapper {

    int selectTotalCount(Map<String, String> searchMap);

    List<BoardDTO> selectFaqBoardList(SelectCriteriaDTO selectCriteria);
}
