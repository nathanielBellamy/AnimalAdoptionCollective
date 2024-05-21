package dev.nateschieber.animaladoptioncollective.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.mockData.MockPersonFactory;
import dev.nateschieber.animaladoptioncollective.mockData.MockPetFactory;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {

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
  public void PersonService_createFromDto_returnsPerson() throws Exception {
      Person person = personService.createFromDto(
          MockPersonFactory.defaultPersonCreateDtos().get(0)
      );

      assertEquals("Steve", person.getName().getFirstName());
      assertEquals("Holt", person.getName().getLastName());
      assertEquals(LocalDate.now(), person.getDateJoined());
      assertEquals(212, person.getPhoneNumbers().get(0).getAreaCode());
      assertEquals("Steve Holt!", person.getNotes().get(0).getBody());
  }
}