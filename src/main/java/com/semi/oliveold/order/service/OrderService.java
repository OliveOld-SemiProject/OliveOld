package com.semi.oliveold.order.service;

import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.OrderMemberDTO;
import com.semi.oliveold.order.dto.ProductDTO;

import java.util.Map;


public interface OrderService {

    /* insert, update, delete 인 경우에는 리턴형은 정수형 */
//    int insertOrderMenu(Map<String, Object> productMap);

    int insertOrderMenu(OrderDTO order);

    int selectProductNo(int orderNo);

    ProductDTO selectProduct(int productNo);

    OrderMemberDTO selectMember(String memberId);

    OrderDTO selectOrderQuan(int orderNo);


    /*String findById(String );*/
}
