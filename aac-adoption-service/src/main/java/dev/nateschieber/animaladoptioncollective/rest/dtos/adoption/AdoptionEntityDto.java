package dev.nateschieber.animaladoptioncollective.rest.dtos.adoption;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.rest.dtos.EventDto;

public record AdoptionEntityDto (Adoption adoption) implements AdoptionDto {}
