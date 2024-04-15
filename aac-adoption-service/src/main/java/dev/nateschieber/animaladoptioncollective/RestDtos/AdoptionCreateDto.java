package dev.nateschieber.animaladoptioncollective.RestDtos;

import java.time.LocalDate;

public record AdoptionCreateDto(LocalDate dateOfAdoption){

  public LocalDate getDateOfAdoption() {
    return dateOfAdoption;
  }
}
