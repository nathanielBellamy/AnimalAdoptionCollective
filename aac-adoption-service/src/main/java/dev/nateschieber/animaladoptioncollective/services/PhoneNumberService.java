package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import dev.nateschieber.animaladoptioncollective.repositories.PhoneNumberRepository;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.PhoneNumberDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.receive.PhoneNumberCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberService {

  private final PhoneNumberRepository phoneNumberRepository;

  @Autowired
  public PhoneNumberService(PhoneNumberRepository phoneNumberRepository) {
    this.phoneNumberRepository = phoneNumberRepository;
  }

  public PhoneNumber save(PhoneNumber phoneNumber) {
    return this.phoneNumberRepository.save(phoneNumber);
  }

  public PhoneNumber createFromDto(PhoneNumberCreateDto dto) {
    PhoneNumber phoneNumber = new PhoneNumber(dto);
    return this.phoneNumberRepository.save(phoneNumber);
  }
}
