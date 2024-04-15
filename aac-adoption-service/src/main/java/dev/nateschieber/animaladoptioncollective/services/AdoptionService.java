package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.repositories.AdoptionDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

  private final AdoptionDatabaseRepository adoptionRepository;

  @Autowired
  public AdoptionService(AdoptionDatabaseRepository adoptionRepository) {
    this.adoptionRepository = adoptionRepository;
  }

  public void printRepo() {
    System.out.println(adoptionRepository);
  }
}
