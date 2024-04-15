package dev.nateschieber.animaladoptioncollective.rest.dtos.adoption;

import java.time.LocalDate;

public record AdoptionCreateDto(LocalDate dateOfAdoption) implements AdoptionDto {
  public LocalDate getDateOfAdoption() {
    return dateOfAdoption;
  }
}
