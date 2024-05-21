package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.data.daos.PetDao;
import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPetDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.entities.Note;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.receive.PetCreateDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

  private final IPetDataAccessor petDao;
  private final NameService nameService;
  private final NoteService noteService;

  @Autowired
  public PetService(
      PetDao petDao,
      NameService nameService,
      NoteService noteService) {
    this.petDao = petDao.runtime;
    this.nameService = nameService;
    this.noteService = noteService;
  }

  public List<Pet> findAll() {
    return petDao.findAll();
  }

  public Optional<Pet> findById(Long id) {
    return petDao.findById(id);
  }

  public Pet save(Pet pet) {
    Name name = pet.getName();
    nameService.save(name);

    List<Note> notes = pet.getNotes();
    notes.forEach(note -> noteService.save(note));
    return petDao.save(pet);
  }

  public Pet createFromDto(PetCreateDto dto) {
    Pet pet = new Pet(dto);

    Name name = pet.getName();
    name.setEntityType(EntityType.PET);
    nameService.save(name);

    noteService.saveAll(pet.getNotes());

    return petDao.save(pet);
  }

  public void deleteAll() {
    petDao.deleteAll();
  }
}
