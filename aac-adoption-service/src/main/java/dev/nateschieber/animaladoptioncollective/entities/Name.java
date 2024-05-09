package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "names")
public class Name {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private UUID uuid;
  @Enumerated(EnumType.STRING)
  private EntityType entityType;
  private String firstNamePreferred;
  private String firstName;

  private String middleName;
  private String lastName;
  private boolean archived = false;

  public Name() {}

  public Name(NameCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.entityType = dto.entityType();
    this.firstName = dto.firstName();
    this.middleName = dto.middleName();
    this.lastName = dto.lastName();
    this.firstNamePreferred = dto.firstNamePreferred();
  }

  @JsonIgnore
  @OneToOne(mappedBy = "name")
  @JoinColumn(nullable = true)
  private Person person;

  @JsonIgnore
  @OneToOne(mappedBy = "name")
  @JoinColumn(nullable = true)
  private Pet pet;

  public String fullName() {
    return switch (this.middleName) {
      case "" -> this.lastName == "" ? this.firstName : String.format("%s %s", this.firstName, this.lastName);
      default -> String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
    };
  }

  public long getId() {
    return id;
  }

  public EntityType getEntityType() {
    return entityType;
  }

  public void setEntityType(EntityType et) {
    this.entityType = et;
  }

  public String getFirstNamePreferred() {
    return firstNamePreferred;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public boolean isArchived() {
    return archived;
  }

  public Person getPerson() {
    return person;
  }

  public Pet getPet() {
    return pet;
  }

  public UUID getUuid() {
    return uuid;
  }
}
