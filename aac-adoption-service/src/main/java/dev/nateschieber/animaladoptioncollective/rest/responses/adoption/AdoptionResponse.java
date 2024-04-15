package dev.nateschieber.animaladoptioncollective.rest.responses.adoption;

import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionDto;

public abstract class AdoptionResponse {
  private AdoptionDto data;

  public AdoptionDto getData() {
    return data;
  }

  public void setData(AdoptionDto data) {
    this.data = data;
  }
}
