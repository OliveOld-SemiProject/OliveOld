package com.semi.oliveold.detail.repository;

import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.detail.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {

    List<DetailDTO> selectProductList();

    List<DetailDTO> findProductListByNo(int no);

    List<DetailDTO> findNewProductListByNo(int no);

    DetailDTO selectProduct();

    List<ReviewDTO> findReviewListByProductNo(int no);
}
