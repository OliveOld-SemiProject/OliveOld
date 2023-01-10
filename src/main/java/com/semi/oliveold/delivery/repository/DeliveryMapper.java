package com.semi.oliveold.delivery.repository;

import com.semi.oliveold.delivery.dto.DeliveryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    List<DeliveryDTO> selectDeliveryList();
}
