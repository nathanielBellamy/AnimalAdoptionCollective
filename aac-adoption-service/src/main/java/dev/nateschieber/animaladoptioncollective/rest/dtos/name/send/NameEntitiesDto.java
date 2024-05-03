package dev.nateschieber.animaladoptioncollective.rest.dtos.name.send;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.NameDto;
import java.util.List;

public record NameEntitiesDto(int count, List<Name> names) implements NameDto {}
