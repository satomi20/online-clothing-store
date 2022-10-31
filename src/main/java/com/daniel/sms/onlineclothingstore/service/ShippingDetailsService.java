package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.Orders;
import com.daniel.sms.onlineclothingstore.entity.ShippingDetails;

import java.util.List;

public interface ShippingDetailsService {

    List<ShippingDetails> findAll();

    List<ShippingDetails> findShippingDetailsByOrders(Orders orders);

}
