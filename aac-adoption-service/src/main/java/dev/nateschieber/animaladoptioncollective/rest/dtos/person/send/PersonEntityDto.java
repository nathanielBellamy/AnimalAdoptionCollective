package dev.nateschieber.animaladoptioncollective.rest.dtos.person.send;

import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.PersonDto;

public record PersonEntityDto(Person person) implements PersonDto {}
