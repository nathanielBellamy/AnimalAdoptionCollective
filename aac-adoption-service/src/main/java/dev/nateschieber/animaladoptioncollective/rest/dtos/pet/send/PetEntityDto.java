package dev.nateschieber.animaladoptioncollective.rest.dtos.pet.send;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.PetDto;

public record PetEntityDto(Pet pet) implements PetDto {}
