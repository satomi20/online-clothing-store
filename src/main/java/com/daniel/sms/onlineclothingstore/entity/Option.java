package com.daniel.sms.onlineclothingstore.entity;

import com.daniel.sms.onlineclothingstore.enums.Color;
import com.daniel.sms.onlineclothingstore.enums.Size;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "option")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Option {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "size")
  @Enumerated(EnumType.STRING)
  private Size size;

  @Column(name = "quantity")
  private String quantity;

  @Column(name = "sku")
  @javax.validation.constraints.Size(min = 13, max = 13)
  private String sku;

  @Column(name = "color_value")
  @Enumerated(EnumType.STRING)
  private Color colorValue;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "product_option",
          joinColumns = @JoinColumn(name = "option_id"),
          inverseJoinColumns = @JoinColumn(name = "product_id"))
  private Set<Product> productOption = new HashSet<>();

}
