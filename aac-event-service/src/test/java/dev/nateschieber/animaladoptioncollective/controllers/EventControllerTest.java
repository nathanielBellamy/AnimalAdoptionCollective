package dev.nateschieber.animaladoptioncollective.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.nateschieber.animaladoptioncollective.entities.Event;
import dev.nateschieber.animaladoptioncollective.rest.dtos.event.EventCreateDto;
import dev.nateschieber.animaladoptioncollective.services.EventService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = EventController.class)
@ExtendWith(MockitoExtension.class)
public class EventControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private EventService eventService;

  @Test
  @DisplayName("EventController#GET /api/v1/events - FindsAll")
  void EventController_GetAllEvents_ReturnsListOfEvent () throws Exception {
    List<Event> mockEvents = List.of(
        new Event(LocalDateTime.of(100, 1, 1, 1, 1, 1)),
        new Event(LocalDateTime.of(1000, 1, 1, 1, 1, 1)),
        new Event(LocalDateTime.of(10000, 1, 1, 1, 1, 1)),
        new Event(LocalDateTime.of(100000, 1, 1, 1, 1, 1)),
        new Event(LocalDateTime.of(1000000, 1, 1, 1, 1, 1))
    );
    doReturn(mockEvents).when(eventService).findAll();

    ResultActions res = mockMvc.perform(get("/api/v1/events"));
    res.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.data.events", isA(ArrayList.class)))
        .andExpect(jsonPath("$.data.events", hasSize(5)));
  }

  @Test
  @DisplayName("EventController#GET /api/v1/events/0 - FindsById")
  void EventController_GetEventById_ReturnsEvent () throws Exception {
    Event mockEvent = new Event(LocalDateTime.of(2024,1, 1, 1, 1, 1, 1));
    doReturn(Optional.of(mockEvent)).when(eventService).findById(0l);

    ResultActions res = mockMvc.perform(get("/api/v1/events/0"));
    res.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.data.event.id", is(0)))
        .andExpect(jsonPath("$.data.event.at", is("2024-01-01T01:01:01.000000001")));
  }

  @Test
  @DisplayName("EventController#POST /api/v1/events/create - Created")
  public void EventController_CreatesEvent_ReturnsEvent () throws Exception {
    LocalDateTime date = LocalDateTime.of(2024, 1, 1, 1, 1, 1, 1);
    EventCreateDto eventCreateDto = new EventCreateDto(date);
    Event event = new Event(date);
    doReturn(event).when(eventService).save(Mockito.any(Event.class));

    ResultActions res = mockMvc.perform(
        post("/api/v1/events/create")
         .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(eventCreateDto))
    );

    res
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(jsonPath("$.data.event.id", is(0)))
        .andExpect(jsonPath("$.data.event.at", is("2024-01-01T01:01:01.000000001")));
  }
}
