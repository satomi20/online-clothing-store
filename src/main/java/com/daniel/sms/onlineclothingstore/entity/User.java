package com.daniel.sms.onlineclothingstore.entity;

import com.daniel.sms.onlineclothingstore.validation.UniqueEmail;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = {"id", "email"})
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @Column(name = "first_name")
  @NotNull
  @NotEmpty(message = "First name cannot be empty.")
  @Size(min = 3, max = 15, message = "The allowed length of the last name is between 3 and 15 symbols")
  private String firstName;

  @Column(name = "last_name")
  @Size(min = 3, max = 15, message = "The allowed length of the last name is between 3 and 15 symbols")
  private String lastName;

  @NotNull
  @Email(message = "Invalid Email.")
  @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Invalid Email")
  @UniqueEmail
  @Column(name = "email"/*, unique = true*/)
  private String email;

  @NotNull
  @Column(name = "password")
  private String password;

  @Pattern(regexp = "^\\+?[1-9][0-9]{7,14}$", message = "Invalid Number")
  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "create_time")
  private java.sql.Timestamp createTime;

  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  @OneToMany(mappedBy="user", cascade =  CascadeType.REMOVE)
  private Set<UserAddress> userAddresses;

  @OneToMany(mappedBy="userId")
  private Set<Orders> orders;

  @Builder.Default
  private Boolean locked = false;

  @Builder.Default
  private Boolean enabled = true;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles();
  }

  @Override
  public String getUsername() {
    return email;
  }
  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName.trim();
  }

  public void setLastName(String lastName) {
    this.lastName = lastName.trim();
  }

  public void setEmail(String email) {
    this.email = email.trim();
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber.trim();
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public void setUserAddresses(Set<UserAddress> userAddresses) {
    this.userAddresses = userAddresses;
  }

  public void setOrders(Set<Orders> orders) {
    this.orders = orders;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  /*  @Transient
  private List<String> role = Arrays.asList("ROLE_USER");
  public List<String> getRoles() {
    return role;
  }*/
}
