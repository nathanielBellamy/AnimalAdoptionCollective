package dev.nateschieber.animaladoptioncollective.rest.responses.name.send;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.send.NameEntitiesDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.name.NameResponse;
import java.util.List;

public class NameGetAllResponse extends NameResponse {
  public NameGetAllResponse(List<Name> names) {
    this.setData( new NameEntitiesDto(names.size(), names));
  }
}
