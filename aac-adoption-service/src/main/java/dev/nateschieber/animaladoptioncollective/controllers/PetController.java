package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.receive.PersonCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.receive.PetCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.person.send.PersonEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.person.send.PersonGetAllResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.pet.PetResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.pet.send.PetEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.pet.send.PetGetAllResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.pet.send.PetInclAdoptionsResponse;
import dev.nateschieber.animaladoptioncollective.services.PetService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pets")
public class PetController {

  private final PetService petService;

  @Autowired
  public PetController(PetService petService) {
    this.petService = petService;
  }

  @GetMapping("")
  @ResponseBody
  public ResponseEntity getAll() {
    List<Pet> pets = petService.findAll();
    return ResponseEntity.ok().body(new PetGetAllResponse(pets));
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity getById(
      @PathVariable Long id,
      @RequestParam(required = false) Boolean includeAdoptions
  ) {
    Optional<Pet> optPet = petService.findById(id);
    if (!optPet.isPresent()) {
      return ResponseEntity.notFound().build();
    } else {
      Pet pet = optPet.get();
      if (includeAdoptions) {
        ResponseEntity resEnt = new ResponseEntity<PetInclAdoptionsResponse>(
            new PetInclAdoptionsResponse(pet),
            HttpStatus.OK
        );
        return resEnt;
      } else {
        ResponseEntity resEnt = new ResponseEntity<PetEntityResponse>(
            new PetEntityResponse(pet),
            HttpStatus.OK
        );
        return resEnt;
      }
    }
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity createPet(@RequestBody PetCreateDto dto) {
    Pet petSaved = petService.createFromDto(dto);
    if (petSaved == null) {
      return ResponseEntity.internalServerError().build();
    }

    URI uri;
    try {
      uri = new URI("/pets/" + petSaved.getId());
    } catch (URISyntaxException e) {
      uri = null;
    }
    return ResponseEntity.created(uri).body(new PetEntityResponse(petSaved));
  }
}
