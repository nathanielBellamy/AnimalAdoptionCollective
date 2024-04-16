package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.rest.dtos.event.EventCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.event.EventCreateDto;
import dev.nateschieber.animaladoptioncollective.entities.Event;
import dev.nateschieber.animaladoptioncollective.rest.responses.event.EventEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.event.EventGetAllResponse;
import dev.nateschieber.animaladoptioncollective.services.EventService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

  private final EventService eventService;
//  private final EventRepository eventService;

  @Autowired
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("")
  @ResponseBody
  public ResponseEntity getAll() {
    List<Event> events = eventService.findAll();
    return ResponseEntity.ok().body(new EventGetAllResponse(events));
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity getById(@PathVariable Long id) {
    Optional<Event> event = eventService.findById(id);
    if (event.isPresent()) {
      ResponseEntity<EventEntityResponse> resEnt = new ResponseEntity<>(
          new EventEntityResponse(event.get()),
          HttpStatus.OK);
      return resEnt;
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity createEvent(@RequestBody EventCreateDto dto) {
    Event event = new Event(dto.getAt());
    Event eventSaved = eventService.save(event);
    if (eventSaved == null) {
      return ResponseEntity.internalServerError().build();
    }

    URI uri;
    try {
      uri = new URI("/events/" + eventSaved.getId());
    } catch (URISyntaxException e) {
      uri = null;
    }
    return ResponseEntity.created(uri).body(new EventEntityResponse(eventSaved));
  }
}
