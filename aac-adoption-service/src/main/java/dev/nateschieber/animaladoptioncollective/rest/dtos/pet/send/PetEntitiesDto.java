package dev.nateschieber.animaladoptioncollective.rest.dtos.pet.send;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.PetDto;
import java.util.List;

public record PetEntitiesDto(int count, List<Pet> pets) implements PetDto {}
