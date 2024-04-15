package dev.nateschieber.animaladoptioncollective.rest.responses.adoption;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionGetAllDto;
import java.util.List;

public class AdoptionGetAllResponse extends AdoptionResponse {
  public AdoptionGetAllResponse(List<Adoption> adoptions) {
    this.setData(new AdoptionGetAllDto(adoptions));
  }
}
