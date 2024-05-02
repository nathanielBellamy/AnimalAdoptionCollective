package dev.nateschieber.animaladoptioncollective.entities;

import dev.nateschieber.animaladoptioncollective.enums.EventType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.event.EventCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  private UUID uuid;
  private LocalDateTime at;
  private EventType eventType;
  // TODO: save as jsonb
  private String data;

  public Event() {}

  public Event(EventCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.eventType = dto.eventType();
    this.at = dto.at();
    this.data = dto.data();
  }

  public long getId() {
    return id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public LocalDateTime getAt() {
    return at;
  }

  public String getData() {
    return data;
  }

  public void setData(final String data) {
    this.data = data;
  }

  public EventType getEventType() {
    return eventType;
  }

  @Override
  public String toString() {
    return "Adoption{" +
        "id=" + id +
        ", uuid=" + uuid +
        ", at=" + at +
        '}';
  }
}
