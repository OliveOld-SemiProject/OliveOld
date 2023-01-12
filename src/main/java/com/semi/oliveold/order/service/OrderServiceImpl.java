package com.semi.oliveold.order.service;


import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.OrderMemberDTO;
import com.semi.oliveold.order.dto.ProductDTO;
import com.semi.oliveold.order.repository.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderMapper mapper;

    public OrderServiceImpl(OrderMapper mapper) {
        this.mapper = mapper;
    }

    //order 등록
    public int insertOrderMenu(OrderDTO order) {

        int insertOrderMenu = mapper.insertOrderMenu(order);

        return insertOrderMenu;
    }

    //1. orderNo로 'productNo' 가져오기
    @Override
    public int selectProductNo(int orderNo) {

        int selectProductNo = mapper.selectProductNo(orderNo);

        return selectProductNo;
    }

    //2. productNo로 '상품 정보' 가져오기
    @Override
    public ProductDTO selectProduct(int productNo){

        ProductDTO product = mapper.selectProduct(productNo);

        return product;
    }

    //3. 로그인 한 memberId로 '회원 정보' 가져오기
    @Override
    public OrderMemberDTO selectMember(String memberId){

        OrderMemberDTO member = mapper.selectMember(memberId);

        return member;
    }

    //4. orderNo로 '주문한 수량' 정보 가져오기
    @Override
    public OrderDTO selectOrderQuan(int orderNo) {

        OrderDTO order = mapper.selectOrderQuan(orderNo);

        return order;
    }

}
