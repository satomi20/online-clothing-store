package com.daniel.sms.onlineclothingstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
@EqualsAndHashCode(of = {"id, name"})
@NoArgsConstructor
@AllArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private Long categoryId;

  @Column(name = "name")
  private String name;

  @Column(name = "url_name")
  private String urlName;

  @OneToMany(mappedBy="category", cascade =  CascadeType.ALL)
  private Set<Product> products;

  @Override
  public String toString() {
    return "Category{" +
            "categoryId=" + categoryId +
            ", name='" + name + '\'' +
            ", urlName='" + urlName +
            '}';
  }
}
