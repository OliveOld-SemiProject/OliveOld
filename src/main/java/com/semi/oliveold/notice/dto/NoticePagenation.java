package com.semi.oliveold.notice.dto;

public class NoticePagenation {

    public static NoticeCriteria getNoticeCriteria(int pageNo, int totalCount, int limit, int buttonAmount){

        return getNoticeCriteria(pageNo, totalCount, limit, buttonAmount, null, null);
    }

    public  static NoticeCriteria getNoticeCriteria(int pageNo, int totalCount, int limit, int buttonAmount, String searchCondition, String searchValue){

        int maxPage;
        int startPage;
        int endPage;
        int startRow;
        int endRow;

        maxPage = (int)Math.ceil((double) totalCount / limit);
        startPage = (int)(Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1;
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

        NoticeCriteria NoticeCriteria = new NoticeCriteria(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow, searchCondition, searchValue);

        return  NoticeCriteria;
    }
}
