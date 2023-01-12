package com.semi.oliveold.delivery.repository;

import com.semi.oliveold.order.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {

    List<OrderDTO> selectDeliveryList(String memberId);

}
