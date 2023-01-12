package com.semi.oliveold.detail.service;

import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.detail.dto.ReviewDTO;
import com.semi.oliveold.detail.repository.DetailMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService{

    private final DetailMapper mapper;

    public DetailServiceImpl(DetailMapper mapper) {

        this.mapper = mapper;
    }
    @Override
    public List<DetailDTO> selectProductList() {

        List<DetailDTO> productList = mapper.selectProductList();

        return productList;
    }


    @Override
    public List<DetailDTO> findProductListByNo(int no) {

        List<DetailDTO> productList = mapper.findProductListByNo(no);

        return productList;
    }

    @Override
    public List<DetailDTO> findNewProductListByNo(int no) {

        List<DetailDTO> newProductList = mapper.findNewProductListByNo(no);

        return newProductList;
    }

    @Override
    public List<ReviewDTO> findReviewListByProductNo(int no) {

        List<ReviewDTO> reviewList = mapper.findReviewListByProductNo(no);

        return reviewList;
    }



    @Override
    public DetailDTO selectProduct() {

        DetailDTO product = mapper.selectProduct();

        return product;
    }



}
