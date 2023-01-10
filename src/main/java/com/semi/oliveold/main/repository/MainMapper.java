package com.semi.oliveold.main.repository;

import com.semi.oliveold.detail.dto.DetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    List<DetailDTO> selectNewProductList();

    List<DetailDTO> selectProductList();


}
