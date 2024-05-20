package dev.nateschieber.animaladoptioncollective.data.jdbcRepositories;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDataSource {
  public static DriverManagerDataSource dataSource;
  public static JdbcClient client;

  static {
    String url = "jdbc:postgresql://localhost:5432/aac-adoption-service";
    String user = "admin";
    String password = "password";

    dataSource = new DriverManagerDataSource(url, user, password);
    client = JdbcClient.create(dataSource);
  }
}
