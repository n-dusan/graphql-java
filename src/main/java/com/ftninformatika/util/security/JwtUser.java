package com.ftninformatika.util.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"id", "password", "lastPasswordResetDate", "lastLoginDate"})
public class JwtUser implements UserDetails {

  private Long id;
  private String username;
  private String firstName;
  private String lastName;
  private String password;
  private String email;
  private Collection<? extends GrantedAuthority> authorities;
  private boolean enabled;
  private LocalDateTime lastPasswordResetDate;
  private LocalDateTime lastLoginDate;

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
}
