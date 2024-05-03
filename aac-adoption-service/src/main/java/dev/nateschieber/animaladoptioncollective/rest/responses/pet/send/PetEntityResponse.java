package dev.nateschieber.animaladoptioncollective.rest.responses.pet.send;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.send.PetEntityDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.pet.PetResponse;

public class PetEntityResponse extends PetResponse {
  public PetEntityResponse(Pet pet) {
    this.setData( new PetEntityDto(pet));
  }
}
