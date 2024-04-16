package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.events.AacEvent;
import dev.nateschieber.animaladoptioncollective.repositories.EventRepository;
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
    this.eventRepository.postEvent(event);
  }
}
