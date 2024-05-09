package dev.nateschieber.animaladoptioncollective.daos;

import dev.nateschieber.animaladoptioncollective.daos.interfaces.IPersonDataAccessor;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.inMemoryStores.PersonInMemoryStore;
import dev.nateschieber.animaladoptioncollective.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {
  public IPersonDataAccessor runtime;

  @Autowired
  public PersonDao(
      PersonRepository personRepository,
      PersonInMemoryStore personInMemoryStore,
      @Value("${aac.data.access}") DataAccess dataAccess
  ) {
    switch (dataAccess) {
      case DataAccess.JPA         -> runtime = personRepository;
      case DataAccess.IN_MEMORY   -> runtime = personInMemoryStore;
    }
  }
}
