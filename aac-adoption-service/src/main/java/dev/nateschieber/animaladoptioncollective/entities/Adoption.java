package dev.nateschieber.animaladoptioncollective.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Adoption {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uuid;
  private LocalDate dateOfAdoption;

  public Adoption() {}

  public Adoption(LocalDate dateOfAdoption) {
    this.dateOfAdoption = dateOfAdoption;
  }


  public UUID getUuid() {
    return uuid;
  }

  public LocalDate getDateOfAdoption() {
    return dateOfAdoption;
  }
}
