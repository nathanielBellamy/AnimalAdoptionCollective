package dev.nateschieber.animaladoptioncollective.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.nateschieber.animaladoptioncollective.mockData.MockAdoptionFactory;
import dev.nateschieber.animaladoptioncollective.mockData.MockPersonFactory;
import dev.nateschieber.animaladoptioncollective.mockData.MockPetFactory;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.services.AdoptionService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.val;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = AdoptionController.class)
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
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
    List<Adoption> mockAdoptions = MockAdoptionFactory.defaultAdoptions();
    doReturn(mockAdoptions).when(adoptionService).findAll();

    ResultActions res = mockMvc.perform(get("/api/v1/adoptions"));
    res.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.data.adoptions", isA(ArrayList.class)))
        .andExpect(jsonPath("$.data.adoptions", hasSize(3)));
  }

  @Test
  @DisplayName("AdoptionController#GET /api/v1/adoptions/0 - FindsById")
  void AdoptionController_GetAdoptionById_ReturnsAdoption () throws Exception {
    Adoption mockAdoption = MockAdoptionFactory.defaultAdoptions().get(0);
    doReturn(Optional.of(mockAdoption)).when(adoptionService).findById(1l);

    ResultActions res = mockMvc.perform(get("/api/v1/adoptions/1"));
    res.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.data.adoption.id", is(1)))
        .andExpect(jsonPath("$.data.adoption.dateOfAdoption", is(LocalDate.now().toString())));
  }

  @Test
  @DisplayName("AdoptionController#POST /api/v1/adoptions/create - Created")
  public void AdoptionController_CreatesAdoption_ReturnsAdoption () throws Exception {
    Adoption mockAdoption = MockAdoptionFactory.defaultAdoptions().get(2);
    mockAdoption.setPersons(
        MockPersonFactory
            .defaultPersons()
            .stream()
            .filter(p -> p.getId() == 1l || p.getId() == 2l)
            .collect(Collectors.toSet())
    );
    mockAdoption.setPet(
        MockPetFactory.defaultPets().get(2)
    );
    doReturn(Optional.of(mockAdoption))
        .when(adoptionService)
        .createFromDto(Mockito.any(AdoptionCreateDto.class));

    val content = objectMapper
        .writeValueAsString(MockAdoptionFactory.defaultAdoptionCreateDtos().get(2));
    ResultActions res = mockMvc.perform(
        post("/api/v1/adoptions/create")
         .contentType(MediaType.APPLICATION_JSON)
            .content(content)
    );

    res
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(jsonPath("$.data.adoption.id", is(3)))
        .andExpect(jsonPath("$.data.adoption.dateOfAdoption", is(LocalDate.now().toString())))
        .andExpect(jsonPath("$.data.adoption.persons", isA(ArrayList.class)))
        .andExpect(jsonPath("$.data.adoption.pet.id", is(3)));
  }
}
