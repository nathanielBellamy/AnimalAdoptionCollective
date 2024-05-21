package dev.nateschieber.animaladoptioncollective.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.matchers.PersonMatcher;
import dev.nateschieber.animaladoptioncollective.mockData.MockPersonFactory;
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

      Optional<Person> optPersonFromDb = personService.findById(person.getId());

      if (!optPersonFromDb.isPresent()) {
        throw new Exception("Did not create Person from Dto");
      }

      Person personFromDb = optPersonFromDb.get();

      assertTrue(new PersonMatcher(person).matches(personFromDb));
  }
}