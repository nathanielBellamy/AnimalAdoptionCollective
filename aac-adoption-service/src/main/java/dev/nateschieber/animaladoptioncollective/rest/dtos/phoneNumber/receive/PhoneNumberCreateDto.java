package dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.receive;

import dev.nateschieber.animaladoptioncollective.enums.PhoneNumberType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.PhoneNumberDto;
import jakarta.validation.constraints.NotNull;

public record PhoneNumberCreateDto(
    Integer countryCode,
    Integer areaCode,
    @NotNull
    Integer number,
    Integer extension,
    PhoneNumberType type
) implements PhoneNumberDto {}
