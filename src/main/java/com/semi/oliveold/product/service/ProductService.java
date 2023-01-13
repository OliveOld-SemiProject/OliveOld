package com.semi.oliveold.product.service;

import com.semi.oliveold.order.dto.ProductDTO;
import com.semi.oliveold.product.dto.CategoryDTO;
import com.semi.oliveold.product.repository.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<CategoryDTO> findByAllCategory(){
        return productMapper.findByAllCategory();
    }

    public int insertProduct(ProductDTO product) {
        return productMapper.insertProduct(product);
    }
}
