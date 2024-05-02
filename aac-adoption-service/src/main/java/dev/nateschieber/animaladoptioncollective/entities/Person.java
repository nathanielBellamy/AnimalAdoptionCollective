package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import java.util.List;
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

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="name_id", referencedColumnName="id")
  private Name name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "person_to_phoneNumber",
      joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "phoneNumber_id")
  )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private Set<PhoneNumber> phoneNumbers;

  @ManyToMany(mappedBy = "persons")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  private Set<Note> notes;

  @ManyToMany(mappedBy = "persons")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  private List<Adoption> adoptions;

  public Person() {}

  public Person(PersonCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.dateJoined = dto.dateJoined() == null ? LocalDate.now() : dto.dateJoined();

    Name name = new Name(dto.name());
    this.name = name;

    Set<PhoneNumber> phoneNumbers = dto.phoneNumbers().stream().map(
        (PhoneNumberCreateDto pnDto) -> new PhoneNumber(pnDto)
    ).collect(Collectors.toSet());
    this.phoneNumbers = phoneNumbers;
  }
}
