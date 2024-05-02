package dev.nateschieber.animaladoptioncollective.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.services.AdoptionService;
import java.time.LocalDate;
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

@WebMvcTest(controllers = AdoptionController.class)
@ExtendWith(MockitoExtension.class)
public class AdoptionControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private AdoptionService adoptionService;

  @Test
  @DisplayName("AdoptionController#GET /api/v1/adoptions - FindsAll")
  void AdoptionController_GetAllAdoptions_ReturnsListOfAdoption () throws Exception {
    List<Adoption> mockAdoptions = List.of(
        new Adoption(new AdoptionCreateDto( LocalDate.of(100, 1, 1))),
        new Adoption(new AdoptionCreateDto( LocalDate.of(1000, 1, 1))),
        new Adoption(new AdoptionCreateDto( LocalDate.of(10000, 1, 1))),
        new Adoption(new AdoptionCreateDto( LocalDate.of(100000, 1, 1))),
        new Adoption(new AdoptionCreateDto( LocalDate.of(1000000, 1, 1)))
    );
    doReturn(mockAdoptions).when(adoptionService).findAll();

    ResultActions res = mockMvc.perform(get("/api/v1/adoptions"));
    res.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.data.adoptions", isA(ArrayList.class)))
        .andExpect(jsonPath("$.data.adoptions", hasSize(5)));
  }

  @Test
  @DisplayName("AdoptionController#GET /api/v1/adoptions/0 - FindsById")
  void AdoptionController_GetAdoptionById_ReturnsAdoption () throws Exception {
    Adoption mockAdoption = new Adoption(
        new AdoptionCreateDto(LocalDate.of(2024,1, 1)));
    doReturn(Optional.of(mockAdoption)).when(adoptionService).findById(0l);

    ResultActions res = mockMvc.perform(get("/api/v1/adoptions/0"));
    res.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.data.adoption.id", is(0)))
        .andExpect(jsonPath("$.data.adoption.dateOfAdoption", is("2024-01-01")));
  }

  @Test
  @DisplayName("AdoptionController#POST /api/v1/adoptions/create - Created")
  public void AdoptionController_CreatesAdoption_ReturnsAdoption () throws Exception {
    LocalDate date = LocalDate.of(2024, 1, 1);
    AdoptionCreateDto adoptionCreateDto = new AdoptionCreateDto(date);
    Adoption adoption = new Adoption(new AdoptionCreateDto(date));
    doReturn(adoption).when(adoptionService).save(Mockito.any(Adoption.class));

    ResultActions res = mockMvc.perform(
        post("/api/v1/adoptions/create")
         .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(adoptionCreateDto))
    );

    res
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(jsonPath("$.data.adoption.id", is(0)))
        .andExpect(jsonPath("$.data.adoption.dateOfAdoption", is("2024-01-01")));
  }
}
