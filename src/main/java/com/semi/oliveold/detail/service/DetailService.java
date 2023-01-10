package com.semi.oliveold.detail.service;

import com.semi.oliveold.detail.dto.DetailDTO;
import com.semi.oliveold.detail.repository.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DetailService {

    List<DetailDTO> selectProductList();

    DetailDTO selectProduct();

    List<DetailDTO> findProductListByNo(int no);
}
