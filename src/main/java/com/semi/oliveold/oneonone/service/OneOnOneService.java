package com.semi.oliveold.oneonone.service;

import com.semi.oliveold.oneonone.dto.OneOnOneBoardDTO;
import com.semi.oliveold.oneonone.dto.OneOnOneSelectCriteriaDTO;
import com.semi.oliveold.oneonone.exception.OneOnOneRegistException;
import com.semi.oliveold.oneonone.repository.OneOnOneBoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OneOnOneService {

    private final OneOnOneBoardMapper mapper;

    public OneOnOneService(OneOnOneBoardMapper mapper){
        this.mapper = mapper;
    }


    public List<OneOnOneBoardDTO> selectOneOnOneBoardList(OneOnOneSelectCriteriaDTO oneOnOneSelectCriteria) {

        List<OneOnOneBoardDTO> oneOnOneBoardList = mapper.selectOneOnOneBoardList(oneOnOneSelectCriteria);

        return oneOnOneBoardList;
    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    public void registOneOnOneBoard(OneOnOneBoardDTO board) throws OneOnOneRegistException {

        int result = mapper.registOneOnOneBoard(board);

             if (!(result > 0)){
                 throw new OneOnOneRegistException("1:1문의 등록에 실패했습니다.");
             }

    }
}
