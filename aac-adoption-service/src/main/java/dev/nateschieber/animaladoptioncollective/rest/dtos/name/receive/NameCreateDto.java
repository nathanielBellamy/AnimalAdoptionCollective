package dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive;

import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.NameDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NameCreateDto(
    @NotNull
    EntityType entityType,
    @NotNull @Size(min=1, max=255)
    String firstName,
    @Size(max=255)
    String middleName,
    @Size(max=255)
    String lastName,
    @Size(max=255)
    String firstNamePreferred
) implements NameDto {}
