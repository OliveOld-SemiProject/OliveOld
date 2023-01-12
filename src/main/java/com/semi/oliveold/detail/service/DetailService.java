package com.semi.oliveold.detail.service;

import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.detail.dto.ReviewDTO;
import com.semi.oliveold.detail.repository.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface DetailService {

    List<DetailDTO> selectProductList();

    DetailDTO selectProduct();

    List<DetailDTO> findProductListByNo(int no);

    List<DetailDTO> findNewProductListByNo(int no);

    List<ReviewDTO> findReviewListByProductNo(int no);


    void registReview(ReviewDTO reviewDTO);


}
