package dev.nateschieber.animaladoptioncollective.rest.responses.event;

import dev.nateschieber.animaladoptioncollective.entities.Event;
import dev.nateschieber.animaladoptioncollective.rest.dtos.event.EventEntityDto;

public class EventEntityResponse extends EventResponse {
  public EventEntityResponse(Event adoption) {
    this.setData(new EventEntityDto(adoption));
  }
}
