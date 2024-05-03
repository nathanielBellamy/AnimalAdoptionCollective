package dev.nateschieber.animaladoptioncollective.rest.responses.person;

import dev.nateschieber.animaladoptioncollective.rest.dtos.person.PersonDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.AacHttpResponse;

public abstract class PersonResponse extends AacHttpResponse {
  private PersonDto data;

  public PersonDto getData() {
    return data;
  }

  public void setData(PersonDto data) {
    this.data = data;
  }
}
