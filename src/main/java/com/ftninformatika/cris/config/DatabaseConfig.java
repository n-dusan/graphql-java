package com.ftninformatika.cris.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatabaseConfig {

  @Profile({Profiles.DEVELOPMENT, Profiles.TEST})
  @Configuration
  static class H2DatabaseConfig {
    @Bean
    public DataSource dataSource(final Environment env) {
      final HikariDataSource ds = new HikariDataSource();
      ds.setJdbcUrl(env.getRequiredProperty("h2.jdbcurl"));
      ds.setUsername(env.getRequiredProperty("h2.username"));
      return ds;
    }
  }

  @Profile({Profiles.DEVELOPMENT2, Profiles.STAGING, Profiles.PRODUCTION})
  @Configuration
  static class PostgresDatabaseConfig {
    @Bean
    public DataSource dataSource(final Environment env) {
      HikariConfig cfg = new HikariConfig();
      cfg.setDriverClassName("org.postgresql.Driver");
      cfg.setJdbcUrl(env.getRequiredProperty("psql.jdbcurl"));
      cfg.setUsername(env.getRequiredProperty("psql.username"));
      cfg.setPassword(env.getRequiredProperty("psql.password"));
      final HikariDataSource ds = new HikariDataSource(cfg);
      //ds.setJdbcUrl(env.getRequiredProperty("psql.jdbcurl"));
      return ds;
    }
  }
}
