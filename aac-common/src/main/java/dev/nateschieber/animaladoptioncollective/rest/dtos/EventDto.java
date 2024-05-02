package dev.nateschieber.animaladoptioncollective.rest.dtos;

import dev.nateschieber.animaladoptioncollective.enums.EventType;
import java.time.LocalDateTime;

public record EventDto(EventType eventType, LocalDateTime at, String json) {}
