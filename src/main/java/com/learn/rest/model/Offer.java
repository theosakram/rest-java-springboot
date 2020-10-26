package com.learn.rest.model;

import java.util.UUID;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class Offer {
  private final long id;

  @ManyToOne
  private final UUID merchantId;

  @NotBlank
  private final String name;
  private String description;
  private String offerType;
  private int numberOfPoints;
  private int rebate;
  private String status;
  private String startDate;
  private String endDate;

  public Offer(long id, UUID merchantId, String name, String description, String offerType, int numberOfPoints,
      int rebate, String status, String startDate, String endDate) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.offerType = offerType;
    this.numberOfPoints = numberOfPoints;
    this.rebate = rebate;
    this.status = status;
    this.startDate = startDate;
    this.endDate = endDate;
    this.merchantId = merchantId;
  }

  public long getId() {
    return id;
  }

  public UUID getMerchantId() {
    return merchantId;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getOfferType() {
    return offerType;
  }

  public int getNumberOfPoints() {
    return numberOfPoints;
  }

  public int getRebate() {
    return rebate;
  }

  public String getStatus() {
    return status;
  }

  public String getStartDate() {
    return startDate;
  }

  public String getEndDate() {
    return endDate;
  }

}
