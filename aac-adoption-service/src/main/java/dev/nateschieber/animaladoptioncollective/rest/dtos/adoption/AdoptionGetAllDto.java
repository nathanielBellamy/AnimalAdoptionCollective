package dev.nateschieber.animaladoptioncollective.rest.dtos.adoption;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import java.util.List;

public record AdoptionGetAllDto(List<Adoption> adoptions) implements AdoptionDto {}