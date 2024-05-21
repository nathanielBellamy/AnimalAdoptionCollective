package dev.nateschieber.animaladoptioncollective.matchers;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import org.mockito.ArgumentMatcher;

public class PetMatcher implements ArgumentMatcher<Pet> {

  public Pet left;

  public PetMatcher(Pet pet) { left = pet; }

  @Override
  public boolean matches(Pet right) {
    return left.getId() == right.getId()
        && new NameMatcher(left.getName()).matches(right.getName())
        && left.getPetType().equals(right.getPetType())
        && left.getPetSize().equals(right.getPetSize())
        && left.getBreed().equals(right.getBreed())
        && left.getDateOfBirth().equals(right.getDateOfBirth())
        && left.getDateOfIntake().equals(right.getDateOfIntake());
  }
}
