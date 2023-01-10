package com.semi.oliveold.order.repository;

import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.OrderMemberDTO;
import com.semi.oliveold.order.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OrderMapper {
//    int insertOrderMenu(Map<String, Object> productMap);

    int insertOrderMenu(OrderDTO order);

    int selectProductNo(int orderNo);

    ProductDTO selectProduct(int productNo);

    OrderMemberDTO selectMember(String memberId);



}
