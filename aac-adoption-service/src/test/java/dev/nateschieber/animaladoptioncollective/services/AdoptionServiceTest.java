package dev.nateschieber.animaladoptioncollective.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.matchers.AdoptionMatcher;
import dev.nateschieber.animaladoptioncollective.mockData.MockPersonFactory;
import dev.nateschieber.animaladoptioncollective.mockData.MockPetFactory;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class AdoptionServiceTest {

  @Autowired
  private PetService petService;
  @Autowired
  private PersonService personService;
  @Autowired
  private AdoptionService adoptionService;
  @Autowired
  private NameService nameService;
  @Autowired
  private PhoneNumberService phoneNumberService;
  @Autowired
  private NoteService noteService;

  @Test
  public void AdoptionService_createFromDto_returnsAdoption() throws Exception {
    Pet mockPet = MockPetFactory.defaultPets().get(0);
    Pet savedPet = petService.save(mockPet);

    Person mockPerson = MockPersonFactory.defaultPersons().get(0);
    Person savedPerson = personService.save(mockPerson);

    Optional<Adoption> optAdoption = adoptionService.createFromDto(
        new AdoptionCreateDto(
            LocalDate.now(),
            List.of(
                new NoteCreateDto("foo bar")
            ),
            List.of(savedPerson.getId()),
            savedPet.getId()
        )
    );

    if (!optAdoption.isPresent()) {
      throw new Exception("Failed to create adoption.");
    }

    Adoption adoption = optAdoption.get();

    Optional<Adoption> optAdoptionFromDb = adoptionService.findById(adoption.getId());

    if (!optAdoptionFromDb.isPresent()) {
      throw new Exception("Failed to save adoption.");
    }

    Adoption adoptionFromDb = optAdoptionFromDb.get();
    assertTrue(new AdoptionMatcher(adoption).matches(adoptionFromDb));
  }
}
