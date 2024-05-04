package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Note;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.events.adoption.AdoptionCreateEvent;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import dev.nateschieber.animaladoptioncollective.rest.clients.EventClient;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

  private final AdoptionRepository adoptionRepository;
  private final NoteService noteService;
  private final PersonService personService;
  private final PetService petService;
  private final EventClient eventClient;

  @Autowired
  public AdoptionService(
      AdoptionRepository adoptionRepository,
      NoteService noteService,
      PersonService personService,
      PetService petService,
      EventClient eventClient) {
    this.adoptionRepository = adoptionRepository;
    this.noteService = noteService;
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

    // Persons and Pet must exist in DB before Adoption is created
    List<Person> persons = personService.findAllById(dto.personIds());
    Optional<Pet> optPet = petService.findById(dto.petId());

    if (persons.size() == 0 || !optPet.isPresent()) {
      return Optional.empty();
    } else {
      Pet pet = optPet.get();

      adoption.setPersons(persons.stream().collect(Collectors.toSet()));
      adoption.setPet(pet);

      // Notes are created with adoption
      List<Note> notes = adoption.getNotes();
      noteService.saveAll(notes);

      Adoption adoptionSaved = adoptionRepository.save(adoption);

      persons.forEach(p -> p.addAdoption(adoption));
      personService.saveAll(persons);
      pet.addAdoption(adoption);
      petService.save(pet);

      return Optional.of(adoptionSaved);
    }
  }

  public void printRepo() {
    System.out.println(adoptionRepository);
  }
}
