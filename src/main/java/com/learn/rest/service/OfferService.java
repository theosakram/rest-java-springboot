package com.learn.rest.service;

import java.util.List;
import java.util.UUID;

import com.learn.rest.entity.OfferEntity;
import com.learn.rest.model.Offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
  private final OfferEntity offerEntity;

  @Autowired
  public OfferService(OfferEntity offerEntity) {
    this.offerEntity = offerEntity;
  }

  public int addOffer(UUID merchantId, Offer offer) {
    return offerEntity.insertOffer(merchantId, offer);
  }

  public List<Offer> getAllOffers(UUID merchantId) throws Exception {
    return offerEntity.getAllOffers(merchantId);
  }

  public List<Offer> getOfferByStatus(UUID merchantId, String status) {
    return offerEntity.getOfferByStatus(merchantId, status);
  }

  public int updateOfferById(long id, Offer newOffer) {
    return offerEntity.updateOfferById(id, newOffer);
  }

  public int deleteOfferById(long id) {
    return offerEntity.deleteOfferById(id);
  }
}
