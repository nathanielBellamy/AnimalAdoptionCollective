package dev.nateschieber.animaladoptioncollective.rest.responses.person.send;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.send.PersonInclAdoptionsDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.person.PersonResponse;
import java.util.List;

public class PersonInclAdoptionsResponse extends PersonResponse {
  public PersonInclAdoptionsResponse(Person person) {
    List<Adoption> adoptions = person.getAdoptions();
    this.setData( new PersonInclAdoptionsDto(person, adoptions.size(), adoptions));
  }
}
