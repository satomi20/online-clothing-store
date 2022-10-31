package com.daniel.sms.onlineclothingstore.entity;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id")
  private Long id;

  @Column(name = "role_name")
  @NotBlank
  private String roleName;

  @Override
  public String getAuthority() {
    return getRoleName();
  }

  public Role() {
  }

  public Role(Long id) {
    this.id = id;
  }

  public Role(Long id, String name) {
    this.id = id;
    this.roleName = name;
  }
}
