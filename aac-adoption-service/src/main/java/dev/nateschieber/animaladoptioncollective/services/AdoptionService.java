package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

  private final AdoptionRepository adoptionRepository;

  @Autowired
  public AdoptionService(AdoptionRepository adoptionRepository) {
    this.adoptionRepository = adoptionRepository;
  }

  public List<Adoption> findAll() {
    return this.adoptionRepository.findAll();
  }

  public Optional<Adoption> findById(Long id) {
    return this.adoptionRepository.findById(id);
  }

  public Adoption save(Adoption adoption) {
    return this.adoptionRepository.save(adoption);
  }

  public void printRepo() {
    System.out.println(adoptionRepository);
  }
}
