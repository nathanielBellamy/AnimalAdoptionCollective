package dev.nateschieber.animaladoptioncollective.rest.responses.phoneNumber.send;

import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.send.PhoneNumberEntityDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.phoneNumber.PhoneNumberResponse;

public class PhoneNumberEntityResponse extends PhoneNumberResponse {
  public PhoneNumberEntityResponse(PhoneNumber phoneNumber) {
    this.setData( new PhoneNumberEntityDto(phoneNumber));
  }
}
