package dev.nateschieber.animaladoptioncollective.rest.responses.event;

import dev.nateschieber.animaladoptioncollective.rest.dtos.event.EventDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.AacHttpResponse;

public abstract class EventResponse extends AacHttpResponse {
  private EventDto data;

  public EventDto getData() {
    return data;
  }

  public void setData(EventDto data) {
    this.data = data;
  }
}
