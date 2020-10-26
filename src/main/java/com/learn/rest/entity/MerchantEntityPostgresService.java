package com.learn.rest.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.learn.rest.model.Merchant;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantEntityPostgresService implements MerchantEntity {

  private final JdbcTemplate jdbcTemplate;

  public MerchantEntityPostgresService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Merchant> getAllMerchants() {
    final String sql = "SELECT * FROM merchant";
    List<Merchant> merchants = jdbcTemplate.query(sql, (ResultSet, i) -> {
      UUID id = UUID.fromString(ResultSet.getString("id"));
      String name = ResultSet.getString("name");
      return new Merchant(id, name);
    });
    return merchants;
  }

  @Override
  public Optional<Merchant> getMerchantById(UUID id) {
    final String sql = "SELECT * FROM merchant WHERE id = ?";
    Merchant merchant = jdbcTemplate.queryForObject(sql, new Object[] { id }, (resultSet, i) -> {
      UUID merchantId = UUID.fromString(resultSet.getString("id"));
      String name = resultSet.getString("name");
      return new Merchant(merchantId, name);
    });
    return Optional.ofNullable(merchant);
  }

}
