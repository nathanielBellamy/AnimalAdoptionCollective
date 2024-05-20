package dev.nateschieber.animaladoptioncollective.data.daos;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPhoneNumberDataAccessor;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.data.inMemoryStores.PhoneNumberInMemoryStore;
import dev.nateschieber.animaladoptioncollective.data.jpaRepositories.JpaPhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDao {
  public IPhoneNumberDataAccessor runtime;

  @Autowired
  public PhoneNumberDao(
      JpaPhoneNumberRepository jpaPhoneNumberRepository,
      PhoneNumberInMemoryStore phoneNumberInMemoryStore,
      @Value("${aac.data.access}") DataAccess dataAccess
  ) {
    switch (dataAccess) {
      case DataAccess.JPA        -> runtime = jpaPhoneNumberRepository;
      case DataAccess.IN_MEMORY  -> runtime = phoneNumberInMemoryStore;
    }
  }
}
