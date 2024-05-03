package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.repositories.PetRepository;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.receive.PetCreateDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

  private final PetRepository petRepository;
  private final NameService nameService;
  private final NoteService noteService;

  @Autowired
  public PetService(
      PetRepository petRepository,
      NameService nameService,
      NoteService noteService) {
    this.petRepository = petRepository;
    this.nameService = nameService;
    this.noteService = noteService;
  }

  public List<Pet> findAll() {
    return petRepository.findAll();
  }

  public Optional<Pet> findById(Long id) {
    return petRepository.findById(id);
  }

  public Pet save(Pet pet) {
    return petRepository.save(pet);
  }

  public Pet createFromDto(PetCreateDto dto) {
    Pet pet = new Pet(dto);

    Name name = pet.getName();
    name.setEntityType(EntityType.PET);
    nameService.save(name);

    noteService.saveAll(pet.getNotes());

    return petRepository.save(pet);
  }
}
