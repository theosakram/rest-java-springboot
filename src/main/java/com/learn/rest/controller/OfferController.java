package com.learn.rest.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.learn.rest.model.Offer;
import com.learn.rest.service.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/offers")
@RestController
public class OfferController {
  private final OfferService offerService;

  @Autowired
  public OfferController(OfferService offerService) {
    this.offerService = offerService;
  }

  @GetMapping(path = "/{merchantId}")
  public List<Offer> getAllOffers(@PathVariable(name = "merchantId") UUID merchantId) throws Exception {
    return offerService.getAllOffers(merchantId);
  }

  @GetMapping(path = "/{merchantId}/{status}")
  public List<Offer> getOfferByStatus(@PathVariable(name = "merchantId") UUID merchantId,
      @PathVariable(name = "status") String status) {
    return offerService.getOfferByStatus(merchantId, status);
  }

  @PostMapping(path = "/{merchantId}")
  public void addOffer(@PathVariable(name = "merchantId") UUID merchantId, @Valid @NonNull @RequestBody Offer offer) {
    offerService.addOffer(merchantId, offer);
  }

  @PutMapping(path = "/{id}")
  public void updateOfferById(@PathVariable(name = "id") long id, @Valid @NonNull @RequestBody Offer newOffer) {
    offerService.updateOfferById(id, newOffer);
  }

  @DeleteMapping(path = "/{id}")
  public void deleteOfferById(@PathVariable(name = "id") long id) {
    offerService.deleteOfferById(id);
  }
}
