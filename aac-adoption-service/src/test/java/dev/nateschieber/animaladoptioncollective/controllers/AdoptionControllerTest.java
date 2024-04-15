package dev.nateschieber.animaladoptioncollective.controllers;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.nateschieber.animaladoptioncollective.RestDtos.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import java.time.LocalDate;
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
  private AdoptionRepository adoptionRepository;

  @Test
  @DisplayName("AdoptionController#GET /adoptions/0 - Found")
  void AdoptionController_GetsAdoption_ReturnsAdoption () throws Exception {
    Adoption mockAdoption = new Adoption(LocalDate.of(2024,1, 1));
    doReturn(Optional.of(mockAdoption)).when(adoptionRepository).findById(0l);

    ResultActions res = mockMvc.perform(get ("/adoptions/0"));
    res.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id", is(0)))
        .andExpect(jsonPath("$.dateOfAdoption", is("2024-01-01")));
  }

  @Test
  @DisplayName("AdoptionController#GET /adoptions/create - Created")
  public void AdoptionController_CreatesAdoption_ReturnsAdoption () throws Exception {
    LocalDate date = LocalDate.of(2024, 1, 1);
    AdoptionCreateDto adoptionCreateDto = new AdoptionCreateDto(date);
    Adoption adoption = new Adoption(date);
    doReturn(adoption).when(adoptionRepository).save(Mockito.any(Adoption.class));

    ResultActions res = mockMvc.perform(
        post("/adoptions/create")
         .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(adoptionCreateDto))
    );

    res
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(jsonPath("$.id", is(0)))
        .andExpect(jsonPath("$.dateOfAdoption", is("2024-01-01")));
  }
}
