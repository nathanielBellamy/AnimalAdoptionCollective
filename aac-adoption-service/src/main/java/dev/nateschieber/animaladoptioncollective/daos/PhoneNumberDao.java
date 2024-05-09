package dev.nateschieber.animaladoptioncollective.daos;

import dev.nateschieber.animaladoptioncollective.daos.interfaces.IPhoneNumberDataAccessor;
import dev.nateschieber.animaladoptioncollective.enums.DataAccess;
import dev.nateschieber.animaladoptioncollective.inMemoryStores.PhoneNumberInMemoryStore;
import dev.nateschieber.animaladoptioncollective.repositories.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDao {
  public IPhoneNumberDataAccessor runtime;

  @Autowired
  public PhoneNumberDao(
      PhoneNumberRepository phoneNumberRepository,
      PhoneNumberInMemoryStore phoneNumberInMemoryStore,
      @Value("${aac.data.access}") DataAccess dataAccess
  ) {
    switch (dataAccess) {
      case DataAccess.JPA        -> runtime = phoneNumberRepository;
      case DataAccess.IN_MEMORY  -> runtime = phoneNumberInMemoryStore;
    }
  }
}
