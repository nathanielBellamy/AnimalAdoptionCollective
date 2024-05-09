package dev.nateschieber.animaladoptioncollective.daos;

import dev.nateschieber.animaladoptioncollective.daos.interfaces.INoteDataAccessor;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.inMemoryStores.NoteInMemoryStore;
import dev.nateschieber.animaladoptioncollective.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NoteDao {
  public INoteDataAccessor runtime;

  @Autowired
  public NoteDao(
      NoteRepository noteRepository,
      NoteInMemoryStore noteInMemoryStore,
      @Value("${aac.data.access}") DataAccess dataAccess
  ) {
    switch (dataAccess) {
      case DataAccess.JPA         -> runtime = noteRepository;
      case DataAccess.IN_MEMORY   -> runtime = noteInMemoryStore;
    }
  }
}
