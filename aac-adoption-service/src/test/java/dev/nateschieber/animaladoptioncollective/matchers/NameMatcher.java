package dev.nateschieber.animaladoptioncollective.matchers;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import org.mockito.ArgumentMatcher;

public class NameMatcher implements ArgumentMatcher<Name> {

  private Name left;

  public NameMatcher(Name name) { left = name; }

  @Override
  public boolean matches(Name right) {
    return left.getId() == right.getId()
        && left.getFirstName().equals(right.getFirstName())
        && left.getLastName().equals(right.getLastName())
        && left.getMiddleName().equals(right.getMiddleName())
        && left.getFirstNamePreferred().equals(right.getFirstNamePreferred());
  }
}
