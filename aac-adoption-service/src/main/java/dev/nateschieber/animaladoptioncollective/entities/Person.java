package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.receive.PersonCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.PhoneNumberDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.receive.PhoneNumberCreateDto;
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
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "persons")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private UUID uuid;
  private LocalDate dateJoined;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="name_id", referencedColumnName="id")
  private Name name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "phone_number_to_person",
      joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "phone_number_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<PhoneNumber> phoneNumbers;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "note_to_person",
      joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "note_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<Note> notes;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "adoption_to_person",
      joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "adoption_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  @JsonIgnore
  private Set<Adoption> adoptions;

  public Person() {}

  public Person(PersonCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.dateJoined = dto.dateJoined() == null ? LocalDate.now() : dto.dateJoined();

    Name name = new Name(dto.name());
    this.name = name;

    Set<PhoneNumber> phoneNumbers = dto.phoneNumbers().stream().map(
        (PhoneNumberCreateDto pncDto) -> new PhoneNumber(pncDto)
    ).collect(Collectors.toSet());
    this.phoneNumbers = phoneNumbers;

    Set<Note> notes = dto.notes().stream().map(
        (NoteCreateDto ncDto) -> new Note(ncDto)
    ).collect(Collectors.toSet());
    this.notes = notes;
  }

  public Long getId() {
    return id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public LocalDate getDateJoined() {
    return dateJoined;
  }

  public Name getName() {
    return name;
  }

  public Set<PhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
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

  public Adoption addAdoption(Adoption adoption) {
    this.adoptions.add(adoption);
    return adoption;
  }
}
