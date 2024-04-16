package dev.nateschieber.animaladoptioncollective.rest.responses.adoption;

import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.AacHttpResponse;

public abstract class AdoptionResponse extends AacHttpResponse {
  private AdoptionDto data;

  public AdoptionDto getData() {
    return data;
  }

  public void setData(AdoptionDto data) {
    this.data = data;
  }
}
