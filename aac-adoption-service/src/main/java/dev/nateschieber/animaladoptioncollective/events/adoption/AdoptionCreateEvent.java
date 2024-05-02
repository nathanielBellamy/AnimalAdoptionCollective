package dev.nateschieber.animaladoptioncollective.events.adoption;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.enums.EventType;
import dev.nateschieber.animaladoptioncollective.events.AacEvent;
import dev.nateschieber.animaladoptioncollective.util.AacAdoptionSerializer;

public class AdoptionCreateEvent extends AacEvent {
  public AdoptionCreateEvent(Adoption adoption) {
    super();
    this.setEventType(EventType.ADOPTION_CREATE);

    String adoptionJson;
    try {
      adoptionJson = AacAdoptionSerializer.getWriter().writeValueAsString(adoption);
    } catch (JsonProcessingException e) {
      adoptionJson = "{ \"error\": \"JsonProcessingError on adoptionId: " + adoption.getId() + " \" }";
    }
    this.setData(adoptionJson);
  }
}
