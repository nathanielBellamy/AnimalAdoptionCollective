package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

  private final AdoptionRepository adoptionRepository;

  @Autowired
  public AdoptionService(AdoptionRepository adoptionRepository) {
    this.adoptionRepository = adoptionRepository;
  }


  public void printRepo() {
    System.out.println(adoptionRepository);
  }
}
