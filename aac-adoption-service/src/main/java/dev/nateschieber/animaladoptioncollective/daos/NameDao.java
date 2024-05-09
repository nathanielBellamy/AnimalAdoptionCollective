package dev.nateschieber.animaladoptioncollective.daos;

import dev.nateschieber.animaladoptioncollective.daoInterfaces.INameDataAccessor;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.inMemoryStores.NameInMemoryStore;
import dev.nateschieber.animaladoptioncollective.repositories.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NameDao {
  public INameDataAccessor runtime;

  @Autowired
  public NameDao(
      NameRepository nameRepository,
      NameInMemoryStore nameInMemoryStore,
      @Value("${aac.data.access}") DataAccess dataAccess
      ) {
    switch (dataAccess) {
      case DataAccess.JPA         -> runtime = nameRepository;
      case DataAccess.IN_MEMORY   -> runtime = nameInMemoryStore;
    }
  }
}
