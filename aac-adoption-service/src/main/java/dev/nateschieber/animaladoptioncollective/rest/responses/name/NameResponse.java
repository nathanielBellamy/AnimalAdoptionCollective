package dev.nateschieber.animaladoptioncollective.rest.responses.name;

import dev.nateschieber.animaladoptioncollective.rest.dtos.name.NameDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.AacHttpResponse;

public abstract class NameResponse extends AacHttpResponse {
  private NameDto data;

  public NameDto getData() {
    return data;
  }

  public void setData(NameDto data) {
    this.data = data;
  }
}
