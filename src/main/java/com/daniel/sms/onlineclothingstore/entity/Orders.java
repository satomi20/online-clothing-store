package com.daniel.sms.onlineclothingstore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "session_id")
  private String sessionId;
  @Column(name = "shipping")
  private Long shipping;
  @Column(name = "total_price")
  private Long totalPrice;
  @Column(name = "order_quantity")
  private Long orderQuantity;
  @Column(name = "order_date")
  private java.sql.Timestamp orderDate;
  @Column(name = "status")
  private String status;
  @Column(name = "created_at")
  private java.sql.Timestamp createdAt;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipping_details_id", nullable = false)
  private ShippingDetails shippingDetailsId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", nullable = false)
  private User userId;

  @OneToMany(mappedBy = "ordersId")
  private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();

  private Long getTotalPrice() {
    long totalPrice = 0;
    for (OrderDetails orderDetails : orderDetails) {
      totalPrice += orderDetails.getPrice();
    }
    return totalPrice;
  }

  private void deleteOrderDetails(OrderDetails order){
    orderDetails.remove(order);
    order.setOrdersId(this);
  }

  private Long getOrderQuantity() {
    long quantity = 0;
    for (OrderDetails orderDetails : orderDetails) {
      quantity += orderDetails.getQuantity();
    }
    return quantity;
  }

  private java.sql.Timestamp getOrderDate(){
    return new java.sql.Timestamp(System.currentTimeMillis());
  }




}
