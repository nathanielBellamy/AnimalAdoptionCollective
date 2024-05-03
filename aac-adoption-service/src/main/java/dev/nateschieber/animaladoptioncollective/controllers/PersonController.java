package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.receive.PersonCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.adoption.send.AdoptionGetAllResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.name.send.NameEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.person.send.PersonEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.person.send.PersonGetAllResponse;
import dev.nateschieber.animaladoptioncollective.services.PersonService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/persons")
public class PersonController {

  private PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("")
  @ResponseBody
  public ResponseEntity getAll() {
    List<Person> persons = personService.findAll();
    return ResponseEntity.ok().body(new PersonGetAllResponse(persons));
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity createPerson(@RequestBody PersonCreateDto dto) {
    Person personSaved = personService.createFromDto(dto);
    if (personSaved == null) {
      return ResponseEntity.internalServerError().build();
    }

    URI uri;
    try {
      uri = new URI("/persons/" + personSaved.getId());
    } catch (URISyntaxException e) {
      uri = null;
    }
    return ResponseEntity.created(uri).body(new PersonEntityResponse(personSaved));
  }
}
