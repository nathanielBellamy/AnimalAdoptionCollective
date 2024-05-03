package dev.nateschieber.animaladoptioncollective.rest.responses.person.send;

import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.send.PersonEntitiesDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.person.PersonResponse;
import java.util.List;

public class PersonGetAllResponse extends PersonResponse {
  public PersonGetAllResponse(List<Person> persons) {
    this.setData( new PersonEntitiesDto(persons.size(), persons));
  }
}
