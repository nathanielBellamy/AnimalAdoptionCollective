package dev.nateschieber.animaladoptioncollective.events;

import dev.nateschieber.animaladoptioncollective.rest.dtos.EventDto;
import java.time.LocalDateTime;

public abstract class AacEvent {

  private LocalDateTime at;
  private EventDto eventDto;

  public AacEvent() {
    this.setAt(LocalDateTime.now());
  }

  public LocalDateTime getAt() {
    return at;
  }

  public void setAt(LocalDateTime at) {
    this.at = at;
  }

  public EventDto getEventDto() {
    return eventDto;
  }

  public void setEventDto(EventDto eventDto) {
    this.eventDto = eventDto;
  }
}
