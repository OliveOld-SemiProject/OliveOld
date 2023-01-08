package com.semi.oliveold.mainsearch.service;


import com.semi.oliveold.mainsearch.dto.SearchProductDTO;
import com.semi.oliveold.mainsearch.dto.SearchProductSelectCriteriaDTO;
import com.semi.oliveold.mainsearch.repository.MainSearchMapper;
import com.semi.oliveold.oneonone.dto.OneOnOneBoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MainSearchService {

    private final MainSearchMapper mapper;

    public MainSearchService(MainSearchMapper mapper) {
        this.mapper = mapper;
    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    public List<SearchProductDTO> selectSearchProductList(SearchProductSelectCriteriaDTO searchProductSelectCriteria) {

        List<SearchProductDTO> searchProductList = mapper.selectSearchProductList(searchProductSelectCriteria);

        return searchProductList;
    }
}
