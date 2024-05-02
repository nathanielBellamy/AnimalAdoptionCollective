package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/phonenumbers")
public class PhoneNumberController {

  private final PhoneNumberService phoneNumberService;

  @Autowired
  public PhoneNumberController(PhoneNumberService phoneNumberService) {
    this.phoneNumberService = phoneNumberService;
  }
}
