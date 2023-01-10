package com.semi.oliveold.oneonone.service;

import com.semi.oliveold.oneonone.dto.OneOnOneBoardDTO;
import com.semi.oliveold.oneonone.dto.OneOnOneSelectCriteriaDTO;
import com.semi.oliveold.oneonone.exception.OneOnOneModifyException;
import com.semi.oliveold.oneonone.exception.OneOnOneRegistException;
import com.semi.oliveold.oneonone.exception.OneOnOneRemoveException;
import com.semi.oliveold.oneonone.repository.OneOnOneBoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OneOnOneService {

    private final OneOnOneBoardMapper mapper;

    public OneOnOneService(OneOnOneBoardMapper mapper){
        this.mapper = mapper;
    }

    public static void fileUpload(OneOnOneBoardDTO oneOnOneBoard, MultipartHttpServletRequest multipartHttpServletRequest) {
        if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false){
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            String name;
            while(iterator.hasNext()){
                name = iterator.next();
                log.debug("file tag name : " + name);
                List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
                for(MultipartFile multipartFile : list){

                }

            }
        }
    }

    public OneOnOneBoardDTO selectBoardDetail(Long no) {

        OneOnOneBoardDTO oneOnOneDetail= null;


        oneOnOneDetail = mapper.selectBoardDetail(no);


        return oneOnOneDetail;
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

    @Transactional
    public void removeOneOnOne(Long no) throws OneOnOneRemoveException {
        int result = mapper.removeOneOnOne(no);

        if(!(result > 0)) {
            throw new OneOnOneRemoveException("삭제에 실패하셨습니다.");
        }

    }


    @Transactional
    public void modifyOneOnOne(OneOnOneBoardDTO oneOnOneBoard) throws OneOnOneModifyException {
        int result = mapper.modifyOneOnOne(oneOnOneBoard);

        if(!(result > 0)){
            throw new OneOnOneModifyException("수정에 실패 했습니다");
        }

    }
}
