package dev.nateschieber.animaladoptioncollective.rest.responses.name.send;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.send.NameEntityDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.name.NameResponse;

public class NameEntityResponse extends NameResponse {
  public NameEntityResponse(Name name) {
    this.setData(new NameEntityDto(name));
  }
}
