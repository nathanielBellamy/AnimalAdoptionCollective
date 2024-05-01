package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.events.AacEvent;
import dev.nateschieber.animaladoptioncollective.repositories.EventRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  private EventRepository eventRepository;

  @Autowired
  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public void postEvent(AacEvent event) {
    try {
      this.eventRepository.postEvent(event);
    } catch (IOException e) {
      // TODO: log e
    }
  }
}
