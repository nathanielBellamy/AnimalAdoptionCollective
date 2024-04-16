package dev.nateschieber.animaladoptioncollective.events.adoption;

import dev.nateschieber.animaladoptioncollective.events.AacEvent;
import dev.nateschieber.animaladoptioncollective.rest.dtos.EventDto;

public class AdoptionCreateEvent extends AacEvent {

  public AdoptionCreateEvent(EventDto dto) {
    this.setEventDto(dto);
  }
}
