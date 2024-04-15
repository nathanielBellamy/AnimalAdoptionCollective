package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.RestDtos.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("adoptions")
public class AdoptionController {

  private final AdoptionRepository adoptionRepository;

  @Autowired
  public AdoptionController(AdoptionRepository adoptionRepository) {
    this.adoptionRepository = adoptionRepository;
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity getById(@PathVariable Long id) {
    Optional<Adoption> adoption = adoptionRepository.findById(id);
    System.out.println(adoption);
    if (adoption.isPresent()) {
      return ResponseEntity.ok().body(adoption.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity createAdoption(@RequestBody AdoptionCreateDto dto) {
    Adoption adoption = new Adoption(dto.getDateOfAdoption());
    Adoption adoptionSaved = adoptionRepository.save(adoption);
    if (adoptionSaved == null) {
      return ResponseEntity.internalServerError().build();
    }

    URI uri;
    try {
      uri = new URI("/adoptions/" + adoptionSaved.getId());
    } catch (URISyntaxException e) {
      uri = null;
    }
    return ResponseEntity.created(uri).body(adoptionSaved);
  }
}
