package com.daniel.sms.onlineclothingstore.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;


@Entity
@Table(name = "user_address")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "user"})
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "address")
  private String adress;
  @Column(name = "country")
  private String country;
  @Column(name = "city")
  private String city;
  @Column(name = "postal_code")
  @Max(value = 6, message = "Wrong number")
  private String postalCode;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name="user_id", nullable=false)
  private User user;

  public UserAddress(String address, String city, String country) {
  }
  public UserAddress(User user){
    this.user = user;
  }

  @Override
  public String toString() {
    return
            "id=" + id +
            ", адрес='" + adress + '\'' +
            ", страна='" + country + '\'' +
            ", город='" + city + '\'' +
            ", почтовый код='" + postalCode + '\'';
  }
}
