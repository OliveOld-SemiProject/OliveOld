package com.semi.oliveold.mainsearch.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchProductSelectCriteriaDTO {

    private int pageNo;
    private int totalCount;
    private int limit;
    private int buttonAmount;           //한번에 보여 줄 페이징 버튼의 갯수
    private int maxPage;
    private int StartPage;
    private int endPage;                //한번에 보여줄 페이징 버튼의 마지막 페이지 수
    private int startRow;               // db 조회시 최신 글 부터 조회 하는 행의 시작 수
    private int endRow;                 // db 조회시 최신 글 부터 조회 하는 행의 마지막 수
    private String searchCondition;     //검색 조건
    private String searchValue;         //검색어
    private String cateCode;         //카테고리 코드

}

