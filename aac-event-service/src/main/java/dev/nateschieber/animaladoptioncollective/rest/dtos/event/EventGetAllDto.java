package dev.nateschieber.animaladoptioncollective.rest.dtos.event;

import dev.nateschieber.animaladoptioncollective.entities.Event;
import java.util.List;

public record EventGetAllDto(List<Event> events) implements EventDto {}