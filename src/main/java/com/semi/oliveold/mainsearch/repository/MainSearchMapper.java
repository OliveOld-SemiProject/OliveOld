package com.semi.oliveold.mainsearch.repository;


import com.semi.oliveold.mainsearch.dto.SearchProductDTO;
import com.semi.oliveold.mainsearch.dto.SearchProductSelectCriteriaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MainSearchMapper {
    int selectTotalCount(Map<String, String> searchMap);

    List<SearchProductDTO> selectSearchProductList(SearchProductSelectCriteriaDTO searchProductSelectCriteria);
}
