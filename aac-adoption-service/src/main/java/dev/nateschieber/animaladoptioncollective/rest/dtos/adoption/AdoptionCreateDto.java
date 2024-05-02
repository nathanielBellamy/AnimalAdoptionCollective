package dev.nateschieber.animaladoptioncollective.rest.dtos.adoption;

import dev.nateschieber.animaladoptioncollective.rest.dtos.EventDto;
import java.time.LocalDate;

public record AdoptionCreateDto(LocalDate dateOfAdoption) implements AdoptionDto { }
