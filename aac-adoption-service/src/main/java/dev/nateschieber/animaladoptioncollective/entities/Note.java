package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "notes")
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @JsonIgnore
  private Long id;

  private UUID uuid;
  private String body;

  public Note() {}

  public Note(NoteCreateDto dto) {
    this.uuid = UUID.randomUUID();
    this.body = dto.body();
  }

  @ManyToMany(mappedBy = "notes")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  @JsonIgnore
  private Set<Adoption> adoptions;

  @ManyToMany(mappedBy = "notes")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  @JsonIgnore
  private Set<Pet> pets;

  @ManyToMany(mappedBy = "notes")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  @JsonIgnore
  public Set<Person> persons;

  public Long getId() {
    return id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getBody() {
    return body;
  }

  public Set<Adoption> getAdoptions() {
    return adoptions;
  }

  public Set<Pet> getPets() {
    return pets;
  }

  public Set<Person> getPersons() {
    return persons;
  }

  @Override
  public String toString() {
    return "Note{\n" +
        "id=" + id +
        ", uuid=" + uuid +
        ", body='" + body + '\'' +
        ", adoptions=" + adoptions +
        ", pets=" + pets +
        ", persons=" + persons +
        "\n}";
  }
}
