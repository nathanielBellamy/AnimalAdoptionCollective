package dev.nateschieber.animaladoptioncollective.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.enums.PetSize;
import dev.nateschieber.animaladoptioncollective.enums.PetType;
import dev.nateschieber.animaladoptioncollective.mockData.MockPetFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PetServiceTest {

  @Autowired
  private PetService petService;
  @Autowired
  private NoteService noteService;

  @Test
  public void PetService_createFromDto_returnsPet() throws Exception {
    Pet pet = petService.createFromDto(
        MockPetFactory.defaultPetCreateDtos().get(0)
    );

    assertEquals("Michelangelo", pet.getName().getFirstName());
    assertEquals(PetType.TURTLE, pet.getPetType());
    assertEquals(PetSize.XL, pet.getPetSize());
    assertEquals("Teenage Mutant Ninja", pet.getBreed());
    assertEquals("Kowabunga", pet.getNotes().get(0).getBody());
  }
}
