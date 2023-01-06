package com.semi.oliveold.detail.repository;

import com.semi.oliveold.detail.dto.DetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {

    List<DetailDTO> selectProductList();

    DetailDTO selectProduct();
}
