package com.learn.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.learn.rest.entity.MerchantEntity;
import com.learn.rest.model.Merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

  private final MerchantEntity merchantEntity;

  @Autowired
  public MerchantService(MerchantEntity merchantEntity) {
    this.merchantEntity = merchantEntity;
  }

  public List<Merchant> getAllMerchants() {
    return merchantEntity.getAllMerchants();
  }

  public Optional<Merchant> getMerchantById(UUID id) {
    return merchantEntity.getMerchantById(id);
  }

}
