package com.semi.oliveold.product.repository;

import com.semi.oliveold.product.dto.CategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<CategoryDTO> findByAllCategory();

}
