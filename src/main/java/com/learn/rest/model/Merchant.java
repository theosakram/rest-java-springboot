package com.learn.rest.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

public class Merchant {
  private final UUID id;

  @NotBlank
  private final String name;

  @OneToMany(mappedBy = "merchantId")
  private List<Offer> offers;

  public Merchant(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Offer> getOffers() {
    return offers;
  }

}
