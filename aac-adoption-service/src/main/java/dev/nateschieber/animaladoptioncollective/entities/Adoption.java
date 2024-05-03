package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "adoptions")
public class Adoption {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private UUID uuid;
  private LocalDate dateOfAdoption;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "note_to_adoption",
      joinColumns = @JoinColumn(name = "adoption_id"),
      inverseJoinColumns = @JoinColumn(name = "note_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Note> notes;

  @ManyToMany(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Person> persons;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="pet_id", referencedColumnName="id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Pet pet;

  public Adoption() {}

  public Adoption(AdoptionCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.dateOfAdoption = dto.dateOfAdoption();
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

  public List<Note> getNotes() {
    return notes.stream().toList();
  }

  public List<Person> getPersons() {
    return persons.stream().toList();
  }

  public Pet getPet() {
    return pet;
  }
}
