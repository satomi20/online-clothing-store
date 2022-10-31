package com.daniel.sms.onlineclothingstore.entity;

import com.daniel.sms.onlineclothingstore.enums.Color;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "product_option")
@Getter
@Setter
@EqualsAndHashCode(of = {"sku", "id", "product_id"})
@NoArgsConstructor
@AllArgsConstructor
public class ProductOption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sku")
  private Long sku;

  @Column(name = "size")
  /*@Pattern(regexp = "^\\w{1}$")*/
  private String size;

  @Column(name = "quantity")
  private Long quantity;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id")
  private Product productId;

  @Override
  public String toString() {
    return   "sku=" + sku +
            ", size=" + size +
            ", quantity='" + quantity;
  }
}
