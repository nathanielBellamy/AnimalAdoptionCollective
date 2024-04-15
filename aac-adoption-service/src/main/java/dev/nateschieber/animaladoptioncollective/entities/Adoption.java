package dev.nateschieber.animaladoptioncollective.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "adoptions")
public class Adoption {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  private UUID uuid;
  private LocalDate dateOfAdoption;

  public Adoption() {}

  public Adoption(LocalDate dateOfAdoption) {
    this.uuid = UUID.randomUUID();
    this.dateOfAdoption = dateOfAdoption;
  }

  public long getId() {
    return id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public LocalDate getDateOfAdoption() {
    return dateOfAdoption;
  }

  @Override
  public String toString() {
    return "Adoption{" +
        "id=" + id +
        ", uuid=" + uuid +
        ", dateOfAdoption=" + dateOfAdoption +
        '}';
  }
}
