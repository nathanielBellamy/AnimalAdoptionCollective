package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.enums.PetSize;
import dev.nateschieber.animaladoptioncollective.enums.PetType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.receive.PetCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "pets")
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private UUID uuid;
  @Enumerated(EnumType.STRING)
  private PetType petType;
  @Enumerated(EnumType.STRING)
  private PetSize petSize;
  private String breed;
  private LocalDate dateOfBirth;
  private LocalDate dateOfIntake;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="name_id", referencedColumnName="id")
  private Name name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "note_to_pet",
      joinColumns = @JoinColumn(name = "pet_id"),
      inverseJoinColumns = @JoinColumn(name = "note_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Note> notes;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name="adoption_id", referencedColumnName="id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  @JsonIgnore
  private Set<Adoption> adoptions;

  public Pet() {}

  public Pet(PetCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.petType = dto.type();
    this.petSize = dto.size();
    this.breed = dto.breed();
    this.dateOfIntake = dto.dateOfIntake() == null ? LocalDate.now() : dto.dateOfIntake();
    this.dateOfBirth = dto.dateOfBirth();

    Name name = new Name(dto.name());
    name.setEntityType(EntityType.PET);
    this.name = name;

    this.notes = dto.notes().stream().map((NoteCreateDto ncd) -> new Note(ncd)).collect(Collectors.toSet());
  }

  public Long getId() {
    return id;
  }

  public PetType getPetType() {
    return petType;
  }

  public PetSize getPetSize() {
    return petSize;
  }

  public String getBreed() {
    return breed;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public LocalDate getDateOfIntake() {
    return dateOfIntake;
  }

  public Name getName() {
    return name;
  }

  public List<Note> getNotes() {
    return Optional
        .ofNullable(notes)
        .orElse(Collections.emptySet())
        .stream()
        .toList();
  }

  public List<Adoption> getAdoptions() {
    return Optional
        .ofNullable(adoptions)
        .orElse(Collections.emptySet())
        .stream()
        .toList();
  }

  public void addAdoption(Adoption adoption) {
    this.adoptions.add(adoption);
  }
}
