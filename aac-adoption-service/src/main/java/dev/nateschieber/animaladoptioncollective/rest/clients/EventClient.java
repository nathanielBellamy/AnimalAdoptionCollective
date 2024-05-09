package dev.nateschieber.animaladoptioncollective.rest.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.nateschieber.animaladoptioncollective.events.adoption.AdoptionCreateEvent;
import dev.nateschieber.animaladoptioncollective.util.AacAdoptionSerializer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Component;

@Component
public class EventClient {
  public static URI uri ;

  static {
    try {
      uri = new URI("http://localhost:5173/api/v1/events/create");
    } catch (URISyntaxException e) {
      uri = null;
    }
  }

  public boolean postEvent(AdoptionCreateEvent event) {
    String jsonStr;
    try {
      jsonStr = AacAdoptionSerializer.getWriter().writeValueAsString(event);
    } catch (JsonProcessingException e) {
      jsonStr = "";
    }
    return postEvent(jsonStr);
  }

  public boolean postEvent(String jsonStr) {
    HttpRequest request = HttpRequest.newBuilder(uri)
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(jsonStr))
        .build();

    try {
      HttpResponse response = HttpClient.newHttpClient()
          .send(request, HttpResponse.BodyHandlers.ofString());
      return response.statusCode() == 200 ? true : false;
    } catch (Exception e){
      return false;
    }
  }
}
