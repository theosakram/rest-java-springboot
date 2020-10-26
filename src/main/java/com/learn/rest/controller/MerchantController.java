package com.learn.rest.controller;

import java.util.List;
import java.util.UUID;

import com.learn.rest.model.Merchant;
import com.learn.rest.service.MerchantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/merchants")
@RestController
public class MerchantController {
  private final MerchantService merchantService;

  @Autowired
  public MerchantController(MerchantService merchantService) {
    this.merchantService = merchantService;
  }

  @GetMapping
  public List<Merchant> getAllMerchants() {
    return merchantService.getAllMerchants();
  }

  @GetMapping(path = "/{id}")
  public Merchant getMerchantById(@PathVariable("id") UUID id) {
    return merchantService.getMerchantById(id).orElse(null);
  }

}
