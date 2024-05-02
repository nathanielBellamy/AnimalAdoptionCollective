package dev.nateschieber.animaladoptioncollective.events;

import dev.nateschieber.animaladoptioncollective.enums.EventType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.EventDto;
import java.time.LocalDateTime;

public abstract class AacEvent {

  private LocalDateTime at;
  private EventDto eventDto;
  private EventType eventType;

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

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }
}
