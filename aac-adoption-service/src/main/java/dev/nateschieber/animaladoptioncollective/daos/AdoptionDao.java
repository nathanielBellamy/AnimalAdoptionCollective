package dev.nateschieber.animaladoptioncollective.daos;

import dev.nateschieber.animaladoptioncollective.daoInterfaces.IAdoptionDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.inMemoryStores.AdoptionInMemoryStore;
import dev.nateschieber.animaladoptioncollective.repositories.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdoptionDao {

  public IAdoptionDataAccessor exec = null;

  @Autowired
  public AdoptionDao(
      AdoptionRepository adoptionRepository,
      AdoptionInMemoryStore adoptionInMemoryStore,
      @Value("${aac.data.access}") DataAccess dataAccess
  ) {
    System.out.println(dataAccess);

    switch(dataAccess) {
     case DataAccess.JPA -> exec = adoptionRepository;
     case DataAccess.IN_MEMORY -> exec = adoptionInMemoryStore;
    }
  }
}
