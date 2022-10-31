package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
