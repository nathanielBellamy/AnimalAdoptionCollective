package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.daos.PhoneNumberDao;
import dev.nateschieber.animaladoptioncollective.daos.interfaces.IPhoneNumberDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.receive.PhoneNumberCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberService {

  private final IPhoneNumberDataAccessor phoneNumberDao;

  @Autowired
  public PhoneNumberService(PhoneNumberDao phoneNumberDao) {
    this.phoneNumberDao = phoneNumberDao.runtime;
  }

  public PhoneNumber save(PhoneNumber phoneNumber) {
    return this.phoneNumberDao.save(phoneNumber);
  }

  public PhoneNumber createFromDto(PhoneNumberCreateDto dto) {
    PhoneNumber phoneNumber = new PhoneNumber(dto);
    return this.phoneNumberDao.save(phoneNumber);
  }
}
