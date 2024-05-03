package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.events.adoption.AdoptionCreateEvent;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import dev.nateschieber.animaladoptioncollective.rest.clients.EventClient;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

  private final AdoptionRepository adoptionRepository;
  private final PersonService personService;
  private final PetService petService;
  private final EventClient eventClient;

  @Autowired
  public AdoptionService(
      AdoptionRepository adoptionRepository,
      PersonService personService,
      PetService petService,
      EventClient eventClient) {
    this.adoptionRepository = adoptionRepository;
    this.personService = personService;
    this.petService = petService;
    this.eventClient = eventClient;
  }

  public List<Adoption> findAll() {
    return this.adoptionRepository.findAll();
  }

  public Optional<Adoption> findById(Long id) {
    return this.adoptionRepository.findById(id);
  }

  public Adoption save(Adoption adoption) {
    Adoption savedAdoption = this.adoptionRepository.save(adoption);

    AdoptionCreateEvent event = new AdoptionCreateEvent(savedAdoption);
    this.eventClient.postEvent(event);

    return savedAdoption;
  }

  public Optional<Adoption> createFromDto(AdoptionCreateDto dto) {
    Adoption adoption = new Adoption(dto);

    List<Person> persons = personService.findAllById(dto.personIds());
    Optional<Pet> pet = petService.findById(dto.petId());

    if (persons.size() == 0 || !pet.isPresent()) {
      return Optional.empty();
    } else {
      personService.saveAll(persons);
      petService.save(pet.get());
    }

    return Optional.of(
        save(adoption)
    );
  }

  public void printRepo() {
    System.out.println(adoptionRepository);
  }
}
