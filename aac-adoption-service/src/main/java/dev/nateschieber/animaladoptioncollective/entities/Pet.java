package dev.nateschieber.animaladoptioncollective.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.nateschieber.animaladoptioncollective.enums.PetSize;
import dev.nateschieber.animaladoptioncollective.enums.PetType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "phone_numbers")
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private PetType petType;
  private PetSize petSize;
  private String breed;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="name_id", referencedColumnName="id")
  private Name name;

  @ManyToMany(mappedBy = "pets")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  private Set<Note> notes;

  @OneToOne(mappedBy = "pet")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  private Adoption adoption;
}
