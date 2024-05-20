package dev.nateschieber.animaladoptioncollective.data.daos;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPetDataAccessor;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.data.inMemoryStores.PetInMemoryStore;
import dev.nateschieber.animaladoptioncollective.data.jpaRepositories.JpaPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PetDao {
  public IPetDataAccessor runtime;

  @Autowired
  public PetDao(
      JpaPetRepository jpaPetRepository,
      PetInMemoryStore petInMemoryStore,
      @Value("${aac.data.access}") DataAccess dataAccess
  ) {
    switch (dataAccess) {
      case DataAccess.JPA        -> runtime = jpaPetRepository;
      case DataAccess.IN_MEMORY  -> runtime = petInMemoryStore;
    }
  }
}