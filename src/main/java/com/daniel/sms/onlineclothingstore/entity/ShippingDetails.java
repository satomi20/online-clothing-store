package com.daniel.sms.onlineclothingstore.entity;

import com.daniel.sms.onlineclothingstore.enums.City;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shipping_details")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShippingDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "phone_number")
  private Long phoneNumber;
  @Column(name = "address")
  private String address;
  @Column(name = "country")
  private String country;
  @Column(name = "city")
  @Enumerated(EnumType.STRING)
  private City city;
  @Column(name = "postal_code")
  private Long postalCode;
  @Column(name = "payment_type")
  private String paymentType;
  @Column(name = "comment")
  @Max(value = 2000, message = "Description must be between 1 and 2000 characters")
  private String comment;

  @OneToMany(mappedBy="shippingDetailsId")
  private Set<Order> orders;




}
