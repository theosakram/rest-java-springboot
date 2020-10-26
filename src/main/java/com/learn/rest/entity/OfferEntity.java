package com.learn.rest.entity;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import com.learn.rest.model.Offer;

public interface OfferEntity {
  int insertOffer(long id, UUID merchantId, Offer offer);

  default int insertOffer(UUID merchantId, Offer offer) {
    AtomicLong id = new AtomicLong();
    return insertOffer(id.incrementAndGet(), merchantId, offer);
  }

  List<Offer> getAllOffers(UUID merchantId) throws Exception;

  List<Offer> getOfferByStatus(UUID merchantId, String status);

  int updateOfferById(long id, Offer newOffer);

  int deleteOfferById(long id);
}
