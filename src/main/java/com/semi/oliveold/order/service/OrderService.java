package com.semi.oliveold.order.service;

import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.OrderMemberDTO;
import com.semi.oliveold.order.dto.ProductDTO;

public interface OrderService {

    /* insert, update, delete 인 경우에는 리턴형은 정수형 */

    //order 등록
    int insertOrderMenu(OrderDTO order);

    //1. orderNo로 'productNo' 가져오기
    int selectProductNo(int orderNo);

    //2. productNo로 '상품 정보' 가져오기
    ProductDTO selectProduct(int productNo);

    //3. 로그인 한 memberId로 '회원 정보' 가져오기
    OrderMemberDTO selectMember(String memberId);

    //4. orderNo로 '주문한 수량' 정보 가져오기
    OrderDTO selectOrderQuan(int orderNo);

}
