package dev.nateschieber.animaladoptioncollective.RestDtos;

import java.time.LocalDate;

public record CreateAdoptionDto(LocalDate dateOfAdoption){

  public LocalDate getDateOfAdoption() {
    return dateOfAdoption;
  }
}
