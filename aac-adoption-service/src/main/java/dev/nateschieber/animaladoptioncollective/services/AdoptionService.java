package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.events.AacEvent;
import dev.nateschieber.animaladoptioncollective.events.adoption.AdoptionCreateEvent;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionCreateDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

  private final AdoptionRepository adoptionRepository;
  private final EventService eventService;

  @Autowired
  public AdoptionService(AdoptionRepository adoptionRepository, EventService eventService) {
    this.adoptionRepository = adoptionRepository;
    this.eventService = eventService;
  }

  public List<Adoption> findAll() {
    return this.adoptionRepository.findAll();
  }

  public Optional<Adoption> findById(Long id) {
    return this.adoptionRepository.findById(id);
  }

  public Adoption save(Adoption adoption) {
    Adoption savedAdoption = this.adoptionRepository.save(adoption);

    AacEvent event = new AdoptionCreateEvent(savedAdoption);
    this.eventService.postEvent(event);

    return savedAdoption;
  }

  public Adoption createFromDto(AdoptionCreateDto dto) {
    Adoption adoption = new Adoption(dto);
    return this.save(adoption);
  }

  public void printRepo() {
    System.out.println(adoptionRepository);
  }
}
