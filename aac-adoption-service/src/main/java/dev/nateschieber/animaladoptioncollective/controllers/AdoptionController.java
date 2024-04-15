package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.RestDtos.CreateAdoptionDto;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionDatabaseRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

  private final AdoptionDatabaseRepository adoptionRepository;

  @Autowired
  public AdoptionController(AdoptionDatabaseRepository adoptionRepository) {
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
  public ResponseEntity createAdoption(@RequestBody CreateAdoptionDto dto) {
    Adoption adoption = new Adoption(dto.getDateOfAdoption());
    Adoption adoptionSaved = adoptionRepository.save(adoption);
    return ResponseEntity.ok().body(adoptionSaved);
  }
}
