package dev.nateschieber.animaladoptioncollective.events;

import dev.nateschieber.animaladoptioncollective.enums.EventType;
import java.time.LocalDateTime;

public abstract class AacEvent {

  private LocalDateTime at;
  private String data;
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

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }
}
