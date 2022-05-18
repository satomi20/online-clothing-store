package com.daniel.sms.onlineclothingstore.entity;

import com.daniel.sms.onlineclothingstore.enums.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "first_name")
  @NotNull
  @NotEmpty(message = "First name cannot be empty.")
  @Max(value = 15, message = "The allowed length of the first name is 15 symbols")
  private String firstName;
  @Column(name = "last_name")
  @NotNull
  @NotEmpty(message = "Last name cannot be empty.")
  @Max(value = 15, message = "The allowed length of the last name is 15 symbols")
  private String lastName;
  @Column(name = "email")
  @NotNull
  @Email(message = "Invalid Email.")
  @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Invalid Email")
  private String email;
  @NotNull
  @Column(name = "password")
  private String password;
  @NotNull
  @Pattern(regexp = "^\\+?[1-9][0-9]{7,14}$", message = "Invalid Number")
  @Column(name = "phone_number")
  private String phoneNumber;
  @Column(name = "create_time")
  private java.sql.Timestamp createTime;

  @Builder.Default
  @Enumerated(EnumType.STRING)
  private Role userRole;

  @OneToMany(mappedBy="userId")
  private Set<UserAddress> userAddresses;
  @OneToMany(mappedBy="userId")
  private Set<Order> orders;



}
