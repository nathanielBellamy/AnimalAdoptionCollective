package dev.nateschieber.animaladoptioncollective.rest.dtos.pet.send;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.PetDto;
import java.util.List;

public record PetInclAdoptionsDto(
    Pet pet,
    int adoptionCount,
    List<Adoption> adoptions
) implements PetDto {}
