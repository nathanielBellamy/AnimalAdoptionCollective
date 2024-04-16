package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Event;
import dev.nateschieber.animaladoptioncollective.repositories.EventRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  private final EventRepository eventRepository;

  @Autowired
  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public List<Event> findAll() {
    return this.eventRepository.findAll();
  }

  public Optional<Event> findById(Long id) {
    return this.eventRepository.findById(id);
  }

  public Event save(Event event) {
    return this.eventRepository.save(event);
  }

  public void printRepo() {
    System.out.println(eventRepository);
  }
}
