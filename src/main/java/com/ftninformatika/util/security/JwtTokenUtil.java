package com.ftninformatika.util.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {

  private static final long serialVersionUID = -3301605591108950415L;

  static final String CLAIM_KEY_USERNAME = "sub";
  static final String CLAIM_KEY_AUDIENCE = "audience";
  static final String CLAIM_KEY_CREATED = "created";

  private static final String AUDIENCE_UNKNOWN = "unknown";
  private static final String AUDIENCE_WEB = "web";
  private static final String AUDIENCE_MOBILE = "mobile";
  private static final String AUDIENCE_TABLET = "tablet";

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private Long expiration;

  public String getUsernameFromToken(String token) {
    String username;
    try {
      final Claims claims = getClaimsFromToken(token);
      username = claims.getSubject();
    } catch (Exception e) {
      username = null;
    }
    return username;
  }

  public LocalDateTime getCreatedDateFromToken(String token) {
    LocalDateTime created;
    try {
      final Claims claims = getClaimsFromToken(token);
      java.util.Date dateCreated = new java.util.Date((Long)claims.get(CLAIM_KEY_CREATED));
      created = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateCreated.getTime()), ZoneId.systemDefault());
    } catch (Exception e) {
      System.err.println(e);
      created = null;
    }
    return created;
  }

  public LocalDateTime getExpirationDateFromToken(String token) {
    LocalDateTime expiration;
    try {
      final Claims claims = getClaimsFromToken(token);
      expiration = LocalDateTime.ofInstant(Instant.ofEpochMilli(claims.getExpiration().getTime()),
          ZoneId.systemDefault());
    } catch (Exception e) {
      expiration = null;
    }
    return expiration;
  }

  public String getAudienceFromToken(String token) {
    String audience;
    try {
      final Claims claims = getClaimsFromToken(token);
      audience = (String) claims.get(CLAIM_KEY_AUDIENCE);
    } catch (Exception e) {
      audience = null;
    }
    return audience;
  }

  private Claims getClaimsFromToken(String token) {
    Claims claims;
    try {
      claims = Jwts.parser()
          .setSigningKey(secret)
          .parseClaimsJws(token)
          .getBody();
    } catch (Exception e) {
      claims = null;
    }
    return claims;
  }

  private LocalDateTime generateExpirationDate() {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis() + expiration * 1000),
        ZoneId.systemDefault());
  }

  private Boolean isTokenExpired(String token) {
    final LocalDateTime expiration = getExpirationDateFromToken(token);
    return expiration.compareTo(LocalDateTime.now()) < 0;
  }

  private Boolean isCreatedBeforeLastPasswordReset(LocalDateTime created, LocalDateTime lastPasswordReset) {
    return (lastPasswordReset != null && created.compareTo(lastPasswordReset) < 0);
  }

//  private String generateAudience(Device device) {
//    String audience = AUDIENCE_UNKNOWN;
//    if (device.isNormal()) {
//      audience = AUDIENCE_WEB;
//    } else if (device.isTablet()) {
//      audience = AUDIENCE_TABLET;
//    } else if (device.isMobile()) {
//      audience = AUDIENCE_MOBILE;
//    }
//    return audience;
//  }

  private Boolean ignoreTokenExpiration(String token) {
    String audience = getAudienceFromToken(token);
    return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
  }

  public String generateToken(UserDetails userDetails)//, Device device)
   {
    Map<String, Object> claims = new HashMap<>();
    claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
   // claims.put(CLAIM_KEY_AUDIENCE, generateAudience(device));
    claims.put(CLAIM_KEY_CREATED, new java.util.Date());
    return generateToken(claims);
  }

  String generateToken(Map<String, Object> claims) {
    return Jwts.builder()
        .setClaims(claims)
        .setExpiration(java.util.Date.from(generateExpirationDate().atZone(ZoneId.systemDefault()).toInstant()))
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  public Boolean canTokenBeRefreshed(String token, LocalDateTime lastPasswordReset) {
    final LocalDateTime created = getCreatedDateFromToken(token);
    return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
        && (!isTokenExpired(token) || ignoreTokenExpiration(token));
  }

  public String refreshToken(String token) {
    String refreshedToken;
    try {
      final Claims claims = getClaimsFromToken(token);
      claims.put(CLAIM_KEY_CREATED, new java.util.Date());
      refreshedToken = generateToken(claims);
    } catch (Exception e) {
      refreshedToken = null;
    }
    return refreshedToken;
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    JwtUser user = (JwtUser) userDetails;
    final String username = getUsernameFromToken(token);
    final LocalDateTime created = getCreatedDateFromToken(token);
    //final Date expiration = getExpirationDateFromToken(token);
    return (
        username.equals(user.getUsername())
            && !isTokenExpired(token)
            && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
  }
}