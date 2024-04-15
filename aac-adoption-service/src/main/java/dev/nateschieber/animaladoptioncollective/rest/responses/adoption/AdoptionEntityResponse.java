package dev.nateschieber.animaladoptioncollective.rest.responses.adoption;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionEntityDto;

public class AdoptionEntityResponse extends AdoptionResponse{
  public AdoptionEntityResponse(Adoption adoption) {
    this.setData(new AdoptionEntityDto(adoption));
  }
}
