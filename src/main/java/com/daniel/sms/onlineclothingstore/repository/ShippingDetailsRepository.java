package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.Orders;
import com.daniel.sms.onlineclothingstore.entity.ShippingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingDetailsRepository extends JpaRepository<ShippingDetails, Long> {
    @Override
    List<ShippingDetails> findAll();

    List<ShippingDetails> findShippingDetailsByOrders(Orders orders);

}
