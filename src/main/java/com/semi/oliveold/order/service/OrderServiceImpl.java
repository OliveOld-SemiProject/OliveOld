package com.semi.oliveold.order.service;


import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.OrderMemberDTO;
import com.semi.oliveold.order.dto.ProductDTO;
import com.semi.oliveold.order.repository.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderMapper mapper;

    public OrderServiceImpl(OrderMapper mapper) {
        this.mapper = mapper;
    }

   /* @Transactional
    @Override
    public int insertOrderMenu(Map<String, Object> productMap) {

        // 주문등록하고
        int insertOrderMenu = mapper.insertOrderMenu(productMap);
        System.out.println("orderList = " + insertOrderMenu);
        // 조건문으로 주문등록이 완료되면 사용자정보, 상품정보를 조회
      //  Map<String, Object>
        return insertOrderMenu;
    }*/


    public int insertOrderMenu(OrderDTO order) {

        int insertOrderMenu = mapper.insertOrderMenu(order);

        return insertOrderMenu;
    }

    @Override
    public int selectProductNo(int orderNo) {

        int selectProductNo = mapper.selectProductNo(orderNo);

        return selectProductNo;
    }

    @Override
    public ProductDTO selectProduct(int productNo){

        ProductDTO product = mapper.selectProduct(productNo);

        return product;
    }

    @Override
    public OrderMemberDTO selectMember(String memberId){

        OrderMemberDTO member = mapper.selectMember(memberId);

        return member;
    }

    @Override
    public OrderDTO selectOrderQuan(int orderNo) {

        OrderDTO order = mapper.selectOrderQuan(orderNo);

        return order;
    }

}
