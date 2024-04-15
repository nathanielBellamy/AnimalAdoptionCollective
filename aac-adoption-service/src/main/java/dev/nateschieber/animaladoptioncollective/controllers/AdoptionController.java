package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import java.util.Optional;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adoptions")
public class AdoptionController {
  @GetMapping("/{id}", produces = "application/json")
  public Optional<Adoption> getBook(@PathVariable long id) {}
}
