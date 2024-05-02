package dev.nateschieber.animaladoptioncollective.rest.dtos.event;

import dev.nateschieber.animaladoptioncollective.enums.EventType;
import java.time.LocalDateTime;

public record EventCreateDto(EventType eventType, LocalDateTime at, String data) implements EventDto {}
