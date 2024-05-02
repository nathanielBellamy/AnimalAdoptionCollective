package dev.nateschieber.animaladoptioncollective.rest.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.nateschieber.animaladoptioncollective.events.AacEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Component;

@Component
public class EventClient {
  public static URI uri ;
  private static ObjectMapper objectMapper;

  static {
    try {
      uri = new URI("http://localhost:5173/api/v1/events/create");
    } catch (URISyntaxException e) {
      uri = null;
    }

    ObjectMapper om = new ObjectMapper();
    om.registerModule(new JavaTimeModule());
    objectMapper = om;
  }

  public boolean postEvent(AacEvent event) {
    ObjectWriter ow = objectMapper.writer();
    String jsonStr;
    try {
      jsonStr = ow.writeValueAsString(event);
    } catch (JsonProcessingException e) {
      jsonStr = "";
    }

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
