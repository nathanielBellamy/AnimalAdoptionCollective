package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.rest.responses.adoption.AdoptionEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.adoption.AdoptionGetAllResponse;
import dev.nateschieber.animaladoptioncollective.services.AdoptionService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/adoptions")
public class AdoptionController {

  private final AdoptionService adoptionService;

  @Autowired
  public AdoptionController(AdoptionService adoptionService) {
    this.adoptionService = adoptionService;
  }

  @GetMapping("")
  @ResponseBody
  public ResponseEntity getAll() {
    List<Adoption> adoptions = adoptionService.findAll();
    return ResponseEntity.ok().body(new AdoptionGetAllResponse(adoptions));
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity getById(@PathVariable Long id) {
    Optional<Adoption> adoption = adoptionService.findById(id);
    if (adoption.isPresent()) {
      ResponseEntity<AdoptionEntityResponse> resEnt = new ResponseEntity<>(
          new AdoptionEntityResponse(adoption.get()),
          HttpStatus.OK);
      return resEnt;
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity createAdoption(@RequestBody AdoptionCreateDto dto) {
    Adoption adoptionSaved = adoptionService.createFromDto(dto);
    if (adoptionSaved == null) {
      return ResponseEntity.internalServerError().build();
    }

    URI uri;
    try {
      uri = new URI("/adoptions/" + adoptionSaved.getId());
    } catch (URISyntaxException e) {
      uri = null;
    }
    return ResponseEntity.created(uri).body(new AdoptionEntityResponse(adoptionSaved));
  }
}