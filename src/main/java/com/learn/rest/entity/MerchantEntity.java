package com.learn.rest.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.learn.rest.model.Merchant;

public interface MerchantEntity {

  List<Merchant> getAllMerchants();

  Optional<Merchant> getMerchantById(UUID id);
}
