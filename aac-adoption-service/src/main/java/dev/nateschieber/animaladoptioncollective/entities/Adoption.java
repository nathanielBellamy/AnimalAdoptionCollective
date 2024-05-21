package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "adoptions")
public class Adoption {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private UUID uuid;
  private LocalDate dateOfAdoption;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "note_to_adoption",
      joinColumns = @JoinColumn(name = "adoption_id"),
      inverseJoinColumns = @JoinColumn(name = "note_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Note> notes;

  @ManyToMany(mappedBy = "adoptions", fetch = FetchType.EAGER)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Set<Person> persons;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Pet pet;

  public Adoption() {}

  public Adoption(AdoptionCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.dateOfAdoption = dto.dateOfAdoption();
    this.notes = Optional
        .ofNullable(dto.notes())
        .orElse(Collections.emptyList())
        .stream()
        .map(ncd -> new Note(ncd))
        .collect(Collectors.toSet());
  }

  public long getId() {
    return id;
  }

  public void setId(long newId) {
    id = newId;
  }

  public UUID getUuid() {
    return uuid;
  }

  public LocalDate getDateOfAdoption() {
    return dateOfAdoption;
  }

  public List<Note> getNotes() {
    return Optional
        .ofNullable(notes)
        .orElse(Collections.emptySet())
        .stream()
        .toList();
  }

  public List<Person> getPersons() {
    return Optional
        .ofNullable(persons)
        .orElse(Collections.emptySet())
        .stream()
        .toList();
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public void setPersons(Set<Person> persons) {
    this.persons = persons;
  }

  @Override
  public String toString() {
    return "Adoption{\n" +
        "id=" + id +
        ", uuid=" + uuid +
        ", dateOfAdoption=" + dateOfAdoption +
        ", notes=" + notes +
        ", persons=" + persons +
        ", pet=" + pet +
        "\n}";
  }
}
