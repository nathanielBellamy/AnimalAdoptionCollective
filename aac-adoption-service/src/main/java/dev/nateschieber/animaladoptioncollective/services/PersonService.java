package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.data.daos.PersonDao;
import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPersonDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.receive.PersonCreateDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final IPersonDataAccessor personDao;
  private final NameService nameService;
  private final NoteService noteService;
  private final PhoneNumberService phoneNumberService;

  @Autowired
  public PersonService(
      PersonDao personDao,
      NameService nameService,
      NoteService noteService,
      PhoneNumberService phoneNumberService) {
    this.personDao = personDao.runtime;
    this.nameService = nameService;
    this.noteService = noteService;
    this.phoneNumberService = phoneNumberService;
  }

  public List<Person> findAll() {
    return personDao.findAll();
  }

  public Optional<Person> findById(Long id) {
    return personDao.findById(id);
  }

  public List<Person> findAllById(List<Long> personIds) {
    return personDao.findAllById(personIds);
  }

  public Person save(Person person) {
    return personDao.save(person);
  }

  public List<Person> saveAll(List<Person> persons) {
    return personDao.saveAll(persons);
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

    return personDao.save(person);
  }
}
