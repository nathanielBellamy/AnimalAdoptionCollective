package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
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
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "notes")
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private UUID uuid;
  private String body;

  public Note() {}

  public Note(NoteCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.body = dto.body();
  }

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "note_to_adoption",
      joinColumns = @JoinColumn(name = "adoption_id"),
      inverseJoinColumns = @JoinColumn(name = "note_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Adoption> adoptions;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "note_to_pet",
      joinColumns = @JoinColumn(name = "pet_id"),
      inverseJoinColumns = @JoinColumn(name = "note_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Pet> pets;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "note_to_person",
      joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "note_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Person> persons;
}
