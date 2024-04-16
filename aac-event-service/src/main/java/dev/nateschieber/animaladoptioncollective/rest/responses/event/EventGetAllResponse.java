package dev.nateschieber.animaladoptioncollective.rest.responses.event;

import dev.nateschieber.animaladoptioncollective.entities.Event;
import dev.nateschieber.animaladoptioncollective.rest.dtos.event.EventGetAllDto;
import java.util.List;

public class EventGetAllResponse extends EventResponse {
  public EventGetAllResponse(List<Event> events) {
    this.setData(new EventGetAllDto(events));
  }
}
