package dev.nateschieber.animaladoptioncollective.rest.dtos.event;

import dev.nateschieber.animaladoptioncollective.entities.Event;

public record EventEntityDto (Event event) implements EventDto {}
