package com.learn.rest.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import com.learn.rest.model.Offer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OfferEntityPostgresService implements OfferEntity {

  private final JdbcTemplate jdbcTemplate;

  public OfferEntityPostgresService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertOffer(long id, UUID merchantId, Offer offer) {
    final String template = "INSERT INTO offer (id, merchantId, name, description , offerType, numberOfPoints, rebate, status, startDate, endDate) VALUES(%i, %s, %s, %s, %s, %i, %i, %s, %s, %s)";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    final String sql = String.format(template, id, merchantId, offer.getName(), offer.getDescription(),
        offer.getOfferType(), offer.getNumberOfPoints(), offer.getRebate(), offer.getStatus(),
        dateFormat.format(offer.getStartDate()), dateFormat.format(offer.getEndDate()));

    jdbcTemplate.execute(sql);
    return 1;
  }

  @Override
  public List<Offer> getAllOffers(UUID merchantId) {
    final String sql = "SELECT * FROM offer WHERE merchantId = ?";
    List<Offer> offers = jdbcTemplate.query(sql, new Object[] { merchantId }, (ResultSet, i) -> {
      long id = ResultSet.getInt("id");
      UUID merchantUuid = UUID.fromString(ResultSet.getString("merchantId"));
      String name = ResultSet.getString("name");
      String description = ResultSet.getString("description");
      String offerType = ResultSet.getString("offerType");
      int numberOfPoints = ResultSet.getInt("number_OfPoints");
      int rebate = ResultSet.getInt("rebate");
      String status = ResultSet.getString("status");
      String startDate = ResultSet.getString("startDate");
      String endDate = ResultSet.getString("endDate");

      return new Offer(id, merchantUuid, name, description, offerType, numberOfPoints, rebate, status, startDate,
          endDate);
    });
    return offers;
  }

  @Override
  public List<Offer> getOfferByStatus(UUID merchantId, String status) {
    final String sql = "SELECT * FROM offer WHERE merchantId = ? AND status = ?";
    List<Offer> offers = jdbcTemplate.query(sql, new Object[] { merchantId, status }, (resultSet, i) -> {
      long id = resultSet.getInt("id");
      UUID merchantUuid = UUID.fromString(resultSet.getString("merchantId"));
      String name = resultSet.getString("name");
      String description = resultSet.getString("description");
      String offerType = resultSet.getString("offerType");
      int numberOfPoints = resultSet.getInt("number_OfPoints");
      int rebate = resultSet.getInt("rebate");
      String offerStatus = resultSet.getString("status");
      String startDate = resultSet.getString("startDate");
      String endDate = resultSet.getString("endDate");

      return new Offer(id, merchantUuid, name, description, offerType, numberOfPoints, rebate, offerStatus, startDate,
          endDate);
    });
    return offers;
  }

  @Override
  public int updateOfferById(long id, Offer newOffer) {
    return 0;
  }

  @Override
  public int deleteOfferById(long id) {
    final String template = "DELETE FROM offer WHERE id = %i";
    final String sql = String.format(template, id);

    jdbcTemplate.execute(sql);
    return 1;
  }

}
