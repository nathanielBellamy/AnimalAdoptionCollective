package dev.nateschieber.animaladoptioncollective.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dev.nateschieber.animaladoptioncollective.events.AacEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {
  public static URI uri ;

  static {
    try {
      uri = new URI("https", "localhost:5173", "/api/v1/events");
    } catch (URISyntaxException e) {
      uri = null;
    }
  }

  public void postEvent(AacEvent event) throws IOException{
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
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
      HttpClient.newHttpClient()
          .send(request, HttpResponse.BodyHandlers.ofString());
    } catch (InterruptedException e){
      // TODO
    }
  }
}
