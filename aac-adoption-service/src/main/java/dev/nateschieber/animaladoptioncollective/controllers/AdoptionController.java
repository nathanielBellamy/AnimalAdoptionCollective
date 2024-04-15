package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adoptions")
public class AdoptionController {

  @Autowired
  @Qualifier("adoptionRepo")
  private AdoptionRepository adoptionRepository;

  @GetMapping("/{uuid}")
  public Adoption getAdoption(@PathVariable UUID uuid) {
    System.out.println(uuid);
    return adoptionRepository.getById(uuid);
  }

  @PostMapping("/")
  public Adoption createAdoption(@RequestBody LocalDate dateOfAdoption) {
    System.out.println(dateOfAdoption);
    Adoption adoption = new Adoption(dateOfAdoption);
    return adoptionRepository.save(adoption);
  }
}
