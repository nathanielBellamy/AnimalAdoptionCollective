package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.enums.PetSize;
import dev.nateschieber.animaladoptioncollective.enums.PetType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.receive.PetCreateDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "pets")
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private PetType petType;
  private PetSize petSize;
  private String breed;
  private LocalDate dateOfBirth;
  private LocalDate dateOfIntake;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="name_id", referencedColumnName="id")
  private Name name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "note_to_pet",
      joinColumns = @JoinColumn(name = "note_id"),
      inverseJoinColumns = @JoinColumn(name = "pet_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Note> notes;

  @OneToOne(mappedBy = "pet")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  private Adoption adoption;

  public Pet() {}

  public Pet(PetCreateDto dto) {
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
    return Optional.of(notes).orElse(Collections.emptySet()).stream().toList();
  }

  public Adoption getAdoption() {
    return adoption;
  }
}
