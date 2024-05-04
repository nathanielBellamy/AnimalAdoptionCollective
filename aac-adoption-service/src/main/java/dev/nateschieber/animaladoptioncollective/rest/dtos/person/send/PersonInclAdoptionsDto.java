package dev.nateschieber.animaladoptioncollective.rest.dtos.person.send;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.PersonDto;
import java.util.List;

public record PersonInclAdoptionsDto(
    Person person,
    int adoptionCount,
    List<Adoption> adoptions
) implements PersonDto {}
