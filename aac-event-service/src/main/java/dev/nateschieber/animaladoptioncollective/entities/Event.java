package dev.nateschieber.animaladoptioncollective.entities;

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

  public Event() {}

  public Event(LocalDateTime at) {
    this.uuid = UUID.randomUUID();
    this.at = at;
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

  @Override
  public String toString() {
    return "Adoption{" +
        "id=" + id +
        ", uuid=" + uuid +
        ", at=" + at +
        '}';
  }
}
