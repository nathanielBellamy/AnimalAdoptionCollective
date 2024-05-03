package dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.send;

import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.PhoneNumberDto;

public record PhoneNumberEntityDto(PhoneNumber phoneNumber) implements PhoneNumberDto {}
