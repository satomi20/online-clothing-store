package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.Order;
import com.daniel.sms.onlineclothingstore.entity.ShippingDetails;

import java.util.List;

public interface ShippingDetailsService {

    List<ShippingDetails> findAll();

    List<ShippingDetails> findShippingDetailsByOrder(Order order);

}
