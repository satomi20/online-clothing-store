package com.daniel.sms.onlineclothingstore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id")
  private Order orderId;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id")
  private Product productId;
  @Column(name = "quantity")
  private Long quantity;
  @Column(name = "price")
  private Long price;

  public Long getPrice() {
    return quantity * price;
  }

}
