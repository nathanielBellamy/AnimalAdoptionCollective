package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.repositories.PersonRepository;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.receive.PersonCreateDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository personRepository;
  private final NameService nameService;
  private final NoteService noteService;
  private final PhoneNumberService phoneNumberService;

  @Autowired
  public PersonService(
      PersonRepository personRepository,
      NameService nameService,
      NoteService noteService,
      PhoneNumberService phoneNumberService) {
    this.personRepository = personRepository;
    this.nameService = nameService;
    this.noteService = noteService;
    this.phoneNumberService = phoneNumberService;
  }

  public List<Person> findAll() {
    return personRepository.findAll();
  }

  public Optional<Person> findById(Long id) {
    return personRepository.findById(id);
  }

  public List<Person> findAllById(List<Long> personIds) {
    return personRepository.findAllById(personIds);
  }

  public Person save(Person person) {
    return personRepository.save(person);
  }

  public List<Person> saveAll(List<Person> persons) {
    return personRepository.saveAll(persons);
  }

  public Person createFromDto(PersonCreateDto dto) {
    Person person = new Person(dto);

    Name name = person.getName();
    name.setEntityType(EntityType.PERSON);
    this.nameService.save(name);

    person.getPhoneNumbers().stream().forEach(pn -> {
      phoneNumberService.save(pn);
    });

    person.getNotes().stream().forEach(note -> {
      noteService.save(note);
    });

    return personRepository.save(person);
  }
}
