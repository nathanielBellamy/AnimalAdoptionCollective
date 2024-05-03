package dev.nateschieber.animaladoptioncollective.rest.responses.phoneNumber;

import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.PhoneNumberDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.AacHttpResponse;

public abstract class PhoneNumberResponse extends AacHttpResponse {
  private PhoneNumberDto data;

  public PhoneNumberDto getData() {
    return data;
  }

  public void setData(PhoneNumberDto data) {
    this.data = data;
  }
}
