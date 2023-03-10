package com.semi.oliveold.faq.service;

import com.semi.oliveold.faq.exception.FaqBoardRegistException;
import com.semi.oliveold.faq.repository.FaqBoardMapper;
import com.semi.oliveold.faq.dto.BoardDTO;
import com.semi.oliveold.faq.dto.SelectCriteriaDTO;
import com.semi.oliveold.oneonone.exception.OneOnOneModifyException;
import com.semi.oliveold.oneonone.exception.OneOnOneRemoveException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class FaqService {

    private final FaqBoardMapper mapper;

    public FaqService(FaqBoardMapper mapper){

        this.mapper = mapper;
    }

    //FAQ등록

    @Transactional
    public void registFaqBoard(BoardDTO board) throws FaqBoardRegistException {

        int result = mapper.insertFaqBoard(board);

        if(!(result > 0)){
            throw new FaqBoardRegistException("Faq 목록 작성에 실패 하셨습니다.");
        }

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

    public BoardDTO selectfaqBoardDetail(Long no) {

        BoardDTO board = null;

        board = mapper.selectfaqBoardDetail(no);

        return board;
    }

    public void modifyfaqBoard(BoardDTO board) throws OneOnOneModifyException {

        int result = mapper.modifyfaqBoard(board);

        if(!(result > 0)){
            throw new OneOnOneModifyException("수정에 실패 했습니다");
        }

    }

    public void removefaqBoard(Long no) throws OneOnOneRemoveException {

        int result = mapper.removefaqBoard(no);

        if(!(result > 0)) {
            throw new OneOnOneRemoveException("삭제에 실패하셨습니다.");
        }

    }
}
