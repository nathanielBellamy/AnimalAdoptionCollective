package dev.nateschieber.animaladoptioncollective.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.matchers.PetMatcher;
import dev.nateschieber.animaladoptioncollective.mockData.MockPetFactory;
import java.util.Optional;
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

    Optional<Pet> optPet = petService.findById(pet.getId());
    if (!optPet.isPresent()) {
      throw new Exception("Did not save pet.");
    }

    Pet dbPet = optPet.get();
    assertTrue(new PetMatcher(pet).matches(dbPet));
  }
}
