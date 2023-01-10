package com.semi.oliveold.main.service;

import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.main.repository.MainMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final MainMapper mapper;


    public MainService(MainMapper mapper) {

        this.mapper = mapper;
    }


    public List<DetailDTO> selectNewProductList() {

        List<DetailDTO> newProductList = mapper.selectNewProductList();

        return newProductList;
    }

    public List<DetailDTO> selectProductList() {

        List<DetailDTO> productList = mapper.selectProductList();

        return productList;
    }


}
