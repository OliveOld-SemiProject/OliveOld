package com.semi.faq.dto;

public class Pagenation {

    public static SelectCriteriaDTO getSelectCriteria(int pageNo, int totalCount, int limit, int buttonAmount){

        return getSelectCriteria(pageNo, totalCount, limit, buttonAmount, null, null);
    }

    public static SelectCriteriaDTO getSelectCriteria(int pageNo, int totalCount, int limit, int buttonAmount, String searchCondition, String searchValue){

        int maxPage;        //전체 페이지에서 가장 마지막 페이지
        int startPage;      //한번에 표시될 페이지 버튼의 시작할 페이지
        int endPage;        //한번에 표시될 페이지 버튼의 끝나는 페이지
        int startRow;
        int endRow;

        maxPage = (int)Math.ceil((double)totalCount / limit); //총페이지 수
        startPage = (int)(Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1 ;
        endPage = startPage + buttonAmount - 1;

        if(maxPage < endPage){
            endPage = maxPage;
        }

        if(maxPage == 0 && endPage == 0){
            maxPage = startPage;
            endPage = startPage;
        }

        startRow = (pageNo - 1) * limit + 1;
        endRow = startRow + limit - 1;

        SelectCriteriaDTO selectCriteria = new SelectCriteriaDTO(pageNo , totalCount, limit, buttonAmount, maxPage, startPage ,endPage,startRow,endRow, searchCondition ,searchValue);

        System.out.println(selectCriteria);

        return selectCriteria;
    }


}
