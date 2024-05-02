package dev.nateschieber.animaladoptioncollective.rest.dtos.name.send;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.NameDto;

public record NameEntityDto(Name name) implements NameDto {}
