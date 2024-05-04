package dev.nateschieber.animaladoptioncollective.rest.responses.adoption.send;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.send.AdoptionGetAllDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.adoption.AdoptionResponse;
import java.util.List;

public class AdoptionGetAllResponse extends AdoptionResponse {
  public AdoptionGetAllResponse(List<Adoption> adoptions) {
    this.setData(new AdoptionGetAllDto(adoptions.size(), adoptions));
  }
}
