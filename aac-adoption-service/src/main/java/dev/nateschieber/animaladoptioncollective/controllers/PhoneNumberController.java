package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.receive.PetCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.receive.PhoneNumberCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.pet.send.PetEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.phoneNumber.send.PhoneNumberEntityResponse;
import dev.nateschieber.animaladoptioncollective.services.PhoneNumberService;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/phonenumbers")
public class PhoneNumberController {

  private final PhoneNumberService phoneNumberService;

  @Autowired
  public PhoneNumberController(PhoneNumberService phoneNumberService) {
    this.phoneNumberService = phoneNumberService;
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity createPhoneNumber(@RequestBody PhoneNumberCreateDto dto) {
    PhoneNumber phoneNumberSaved = phoneNumberService.createFromDto(dto);
    if (phoneNumberSaved == null) {
      return ResponseEntity.internalServerError().build();
    }

    URI uri;
    try {
      uri = new URI("/phoneNumbers/" + phoneNumberSaved.getId());
    } catch (URISyntaxException e) {
      uri = null;
    }
    return ResponseEntity.created(uri).body(new PhoneNumberEntityResponse(phoneNumberSaved));
  }
}
