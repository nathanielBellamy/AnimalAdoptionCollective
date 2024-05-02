package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.events.AacEvent;
import dev.nateschieber.animaladoptioncollective.rest.clients.EventClient;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  private EventClient eventClient;

  @Autowired
  public EventService(EventClient eventClient) {
    this.eventClient = eventClient;
  }

  public void postEvent(AacEvent event) {
      this.eventClient.postEvent(event);
  }
}
