package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.nateschieber.animaladoptioncollective.enums.PhoneNumberType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.receive.PhoneNumberCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @JsonIgnore
  private Long id;

  private UUID uuid;
  private Integer countryCode;
  private Integer areaCode;
  private Integer number;
  private Integer extension;
  private boolean archived = false;
  @Enumerated(EnumType.STRING)
  private PhoneNumberType type;


  @ManyToMany(mappedBy = "phoneNumbers")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  private Set<Person> persons;

  public PhoneNumber() {}

  public PhoneNumber(PhoneNumberCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.countryCode = dto.countryCode(); // maybe null
    this.areaCode = dto.areaCode();
    this.number = dto.number();
    this.extension = dto.extension();
    this.type = dto.type();
    this.archived = Optional.ofNullable(dto.archived()).orElse(false);
  }

  public long getId() {
    return id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public Integer getCountryCode() {
    return countryCode;
  }

  public Integer getAreaCode() {
    return areaCode;
  }

  public Integer getNumber() {
    return number;
  }

  public Integer getExtension() {
    return extension;
  }

  public boolean getArchived() {
    return archived;
  }

  public boolean isArchived() {
    return archived;
  }

  public PhoneNumberType getType() {
    return type;
  }

  public List<Person> getPersons() {
    return persons.stream().toList();
  }
}
