package com.daniel.sms.onlineclothingstore.entity;


import com.daniel.sms.onlineclothingstore.enums.Color;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "article"})
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  @Column(name = "name")
  @NotEmpty(message = "Product name cannot be empty.")
  private String name;
  @Column(name = "url_name")
  private String urlName;
  @Column(name = "article")
  @Size(min = 0, max = 20, message = "The article must consist of 20 symbols")
  private String article;

  @Column(name = "color")
  private String color;

  @Column(name = "price")
  @PositiveOrZero
  private Long price;
  @Column(name = "old_price")
  @PositiveOrZero
  private Long oldPrice;
  @Column(name = "image_path")
  private String imagePath;
  @Column(length = 2000)
  @Size(min = 1, max = 2000, message = "Description must be between 1 and 2000 characters")
  private String description;
  @Column(name = "percent_discount")
  @Max(100)
  private Long percentDiscount;
  @Column(name = "sale")
  private Boolean sale;
  @Column(name = "new_product")
  private Boolean new_product;

  @OneToMany(mappedBy = "productId")
  private Set<OrderDetails> userGroups = new HashSet<OrderDetails>();

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(mappedBy = "productId", cascade = CascadeType.PERSIST, orphanRemoval = true)
  private Set<ProductOption> productOptions = new HashSet<>();

  @Column(name = "createdAt")
  private java.sql.Timestamp createdAt;
  @Column(name = "updatedAt")
  private java.sql.Timestamp updatedAt;

  /*public Long getPrice() {
    return oldPrice - (oldPrice * percentDiscount / 100);
  }*/

  /*public static void main(String[] args) {
    Product product = new Product();
    product.setOldPrice(7000L);
    product.setPercentDiscount(57L);
    Long price = product.getPrice();
    System.out.println(price);
  }*/
}
