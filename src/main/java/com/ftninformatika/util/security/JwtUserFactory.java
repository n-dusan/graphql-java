package com.ftninformatika.util.security;

import com.ftninformatika.cris.model.user.Authority;
import com.ftninformatika.cris.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

  private JwtUserFactory() {
  }

  public static JwtUser create(User user) {
    return new JwtUser(
        user.getId(),
        user.getUsername(),
        user.getFirstName(),
        user.getLastName(),
        user.getPassword(),
        user.getEmail(),
        mapToGrantedAuthorities(user.getAuthorities()),
        user.getEnabled(),
        user.getLastPasswordResetDate(),
        user.getLastLoginDate()
    );
  }

  private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
    return authorities.stream()
        .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
        .collect(Collectors.toList());
  }
}
