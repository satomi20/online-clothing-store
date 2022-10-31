package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.Orders;
import com.daniel.sms.onlineclothingstore.entity.ShippingDetails;
import com.daniel.sms.onlineclothingstore.repository.ShippingDetailsRepository;
import com.daniel.sms.onlineclothingstore.service.ShippingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingDetailsImpl implements ShippingDetailsService {

    ShippingDetailsRepository shippingDetailsRepository;

    @Autowired
    public ShippingDetailsImpl(ShippingDetailsRepository shippingDetailsRepository) {
        this.shippingDetailsRepository = shippingDetailsRepository;
    }

    @Override
    public List<ShippingDetails> findAll() {
        return shippingDetailsRepository.findAll();
    }

    @Override
    public List<ShippingDetails> findShippingDetailsByOrders(Orders orders) {
        return shippingDetailsRepository.findShippingDetailsByOrders(orders);
    }
}
