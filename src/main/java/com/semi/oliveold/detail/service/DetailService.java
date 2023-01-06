package com.semi.oliveold.detail.service;

import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.detail.repository.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    private final DetailMapper mapper;



    public DetailService(DetailMapper mapper) {

        this.mapper = mapper;
    }


    public List<DetailDTO> selectProductList() {

        List<DetailDTO> productList = mapper.selectProductList();

        return productList;
    }

    public DetailDTO selectProduct() {

        DetailDTO product = mapper.selectProduct();

        return product;
    }
}
