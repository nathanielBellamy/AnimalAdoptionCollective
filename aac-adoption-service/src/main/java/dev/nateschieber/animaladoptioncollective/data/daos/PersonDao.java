package dev.nateschieber.animaladoptioncollective.data.daos;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPersonDataAccessor;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.data.inMemoryStores.PersonInMemoryStore;
import dev.nateschieber.animaladoptioncollective.data.repositories.PersonRepository;
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
