package dev.nateschieber.animaladoptioncollective.rest.responses.pet.send;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.send.PetEntitiesDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.pet.PetResponse;
import java.util.List;

public class PetGetAllResponse extends PetResponse {
  public PetGetAllResponse(List<Pet> pets) {
    this.setData( new PetEntitiesDto(pets.size(), pets));
  }
}
