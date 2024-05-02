package dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.send;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionDto;
import java.util.List;

public record AdoptionGetAllDto(List<Adoption> adoptions) implements AdoptionDto {}