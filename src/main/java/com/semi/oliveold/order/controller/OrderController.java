package com.semi.oliveold.order.controller;

import com.semi.oliveold.member.dto.MemberDTO;
import com.semi.oliveold.member.dto.UserImpl;
import com.semi.oliveold.order.dto.OrderDTO;
import com.semi.oliveold.order.dto.OrderMemberDTO;
import com.semi.oliveold.order.dto.ProductDTO;
import com.semi.oliveold.order.service.OrderService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    // 로그정보를 처리하는 객체 생성
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //orderService로 이동
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 상품 상세 보기에서 '바로구매' 클릭 시, 구매 테이블에 상품 insert하기
    @GetMapping("/registOrder")
    public String insertOrderMenu(@AuthenticationPrincipal User user, @RequestParam int productNo) {

        // productNo가 잘 들어오는지 확인
        System.out.println("productNo : " + productNo);

        // memberId가 잘 들어오는지 확인
        System.out.println("user.getUsername() : " + user.getUsername());

        //OrderDTO에 productNo와 memberId를 담아서 넘기기
        OrderDTO order = new OrderDTO();
        order.setProductNo(productNo);
        order.setMemberId(user.getUsername());

        int result =  orderService.insertOrderMenu(order);

        //order에 값이 잘 나오는 지 확인
        System.out.println("==========order : " + order);

        //orderN(auto increment)를 담아서 orderProductDetail로 이동
        return "redirect:/order/orderProductDetail/"+ order.getOrderNo();
    }

    @GetMapping("/orderProductDetail/{orderNo}")
    public ModelAndView selectOrderMenu(@AuthenticationPrincipal User user,
                                        @PathVariable("orderNo") int orderNo, ModelAndView mv){

        //insert하면서 orderNo 가져온 것 확인
        System.out.println("============orderNo : " + orderNo);

        //1. orderNo로 'productNo' 가져오기
        int productNo = orderService.selectProductNo(orderNo);

        //2. productNo로 '상품 정보' 가져오기
        ProductDTO product = orderService.selectProduct(productNo);
        System.out.println("product ================> " + product);

        //3. 로그인 한 memberId로 '회원 정보' 가져오기
        OrderMemberDTO member = orderService.selectMember(user.getUsername());
        System.out.println("member ==================> " + member);

        //4. orderNo로 '주문한 수량' 정보 가져오기
        OrderDTO order = orderService.selectOrderQuan(orderNo);
        System.out.println("order ==================> " + order);

        // DB에 회원가입 시 입력된 전화번호 형태 '010-0000-0000'
        // -> 하이픈(-)으로 나누어서 각 칸에 맞게 변경
        String[] phoneNum = member.memberPhone.split("-");
        for(int i = 0; i < phoneNum.length; i++){
            member.setPhone1(phoneNum[0]);
            member.setPhone2(phoneNum[1]);
            member.setPhone3(phoneNum[2]);
        }

        // DB에 회원가입 시 입력된 주소 형태 '000-00/서울시 종로구 인사동 12/7층'
        // -> 슬러쉬(/)으로 나누어서 각 칸에 맞게 변경
        // % 와 $는 구분자로 안됨(이유는 추가로 찾아볼 것!)
        String[] arrAddress = member.memberAddress.split("/");

        for (int i = 0; i <arrAddress.length; i++){
            member.setZipcode(arrAddress[0]);
            member.setAddress1(arrAddress[1]);
            member.setAddress2(arrAddress[2]);
        }

        //2. 상품 정보 3. 회원 정보 4. 주문 수량 값들 넣어서 뷰로 전달!
        mv.addObject("product", product);
        mv.addObject("member", member);
        mv.addObject("order", order);

        System.out.println("<<<<<<=============== 확인용 ===============>>>>>>");
        mv.setViewName("/order-payment");

        return mv;
    }

}
