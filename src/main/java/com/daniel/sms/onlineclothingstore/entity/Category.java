package com.daniel.sms.onlineclothingstore.entity;

import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private Long categoryId;

  @Column(name = "name")
  private String name;

  @Column(name = "url_name")
  private String urlName;

  @Column(name = "parent_id")
  private Long parentId;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "product_category",
          joinColumns = @JoinColumn(name = "category_id"),
          inverseJoinColumns = @JoinColumn(name = "product_id"))
  private Set<Product> productCategory = new HashSet<>();
}
