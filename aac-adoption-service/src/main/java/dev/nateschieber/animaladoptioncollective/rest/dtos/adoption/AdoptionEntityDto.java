package dev.nateschieber.animaladoptioncollective.rest.dtos.adoption;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;

public record AdoptionEntityDto (Adoption adoption) implements AdoptionDto {}
