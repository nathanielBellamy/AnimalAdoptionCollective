package dev.nateschieber.animaladoptioncollective.rest.dtos.event;

import java.time.LocalDateTime;

public record EventCreateDto(LocalDateTime at) implements EventDto {
  public LocalDateTime getAt() {
    return at;
  }
}
