package dev.nateschieber.animaladoptioncollective.rest.dtos.person.send;

import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.PersonDto;
import java.util.List;

public record PersonEntitiesDto(int size, List<Person> persons) implements PersonDto {}
