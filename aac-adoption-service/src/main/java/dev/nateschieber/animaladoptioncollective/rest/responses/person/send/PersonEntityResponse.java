package dev.nateschieber.animaladoptioncollective.rest.responses.person.send;

import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.PersonDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.send.PersonEntityDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.person.PersonResponse;

public class PersonEntityResponse extends PersonResponse {
  public PersonEntityResponse(Person person) {
    this.setData( new PersonEntityDto(person));
  }
}
