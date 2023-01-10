package com.semi.oliveold.delivery.service;

import com.semi.oliveold.delivery.dto.DeliveryDTO;
import com.semi.oliveold.delivery.repository.DeliveryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryMapper mapper;

    public DeliveryService(DeliveryMapper mapper) {
        this.mapper = mapper;
    }

    public List<DeliveryDTO> selectDeliveryList(){

        List<DeliveryDTO> deliveryList = mapper.selectDeliveryList();

        return deliveryList;
    }
}
