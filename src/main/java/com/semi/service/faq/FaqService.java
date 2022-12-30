package com.semi.service.faq;

import com.semi.dao.faq.FaqBoardMapper;
import com.semi.dto.Board.BoardDTO;
import com.semi.dto.Board.SelectCriteriaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FaqService {

    private final FaqBoardMapper mapper;

    public FaqService(FaqBoardMapper mapper){
        this.mapper = mapper;
    }

    // 게시글의 전체 갯수 조회용//
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    //게시글 전체 조회용//
    public List<BoardDTO> selectFaqBoardList(SelectCriteriaDTO selectCriteria) {

        List<BoardDTO> faqBoardList = mapper.selectFaqBoardList(selectCriteria);

        return faqBoardList;
    }
}
