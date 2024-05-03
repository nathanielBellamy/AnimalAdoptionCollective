package dev.nateschieber.animaladoptioncollective.rest.responses.pet;

import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.PetDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.AacHttpResponse;

public abstract class PetResponse extends AacHttpResponse {
  private PetDto data;

  public PetDto getData() {
    return data;
  }

  public void setData(PetDto data) {
    this.data = data;
  }
}
