package dev.nateschieber.animaladoptioncollective.rest.responses.pet.send;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.send.PetInclAdoptionsDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.pet.PetResponse;
import java.util.List;

public class PetInclAdoptionsResponse extends PetResponse {
  public PetInclAdoptionsResponse(Pet pet) {
    List<Adoption> adoptions = pet.getAdoptions();
    this.setData( new PetInclAdoptionsDto(pet, adoptions.size(), adoptions));
  }
}