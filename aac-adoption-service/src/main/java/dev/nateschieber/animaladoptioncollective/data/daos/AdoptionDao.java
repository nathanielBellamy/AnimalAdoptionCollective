package dev.nateschieber.animaladoptioncollective.data.daos;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IAdoptionDataAccessor;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.data.inMemoryStores.AdoptionInMemoryStore;
import dev.nateschieber.animaladoptioncollective.data.jpaRepositories.JpaAdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdoptionDao {

  public IAdoptionDataAccessor runtime;

  @Autowired
  public AdoptionDao(
      JpaAdoptionRepository jpaAdoptionRepository,
      AdoptionInMemoryStore adoptionInMemoryStore,
      @Value("${aac.data.access}") DataAccess dataAccess
  ) {
    System.out.println(dataAccess);

    switch(dataAccess) {
     case DataAccess.JPA -> runtime = jpaAdoptionRepository;
     case DataAccess.IN_MEMORY -> runtime = adoptionInMemoryStore;
    }
  }
}
