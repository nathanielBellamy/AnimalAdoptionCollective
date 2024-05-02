package dev.nateschieber.animaladoptioncollective.events.adoption;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.enums.EventType;
import dev.nateschieber.animaladoptioncollective.events.AacEvent;

public class AdoptionCreateEvent extends AacEvent {
  private Adoption adoption;

  public AdoptionCreateEvent(Adoption adoption) {
    super();
    this.setEventType(EventType.ADOPTION_CREATE);
    this.adoption = adoption;
  }
}
