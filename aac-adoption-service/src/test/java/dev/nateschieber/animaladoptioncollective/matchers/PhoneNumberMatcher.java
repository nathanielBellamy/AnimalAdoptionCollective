package dev.nateschieber.animaladoptioncollective.matchers;

import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import org.mockito.ArgumentMatcher;

public class PhoneNumberMatcher implements ArgumentMatcher<PhoneNumber> {

  public PhoneNumber left;

  public PhoneNumberMatcher(PhoneNumber phoneNumber) { left = phoneNumber; }

  @Override
  public boolean matches(PhoneNumber right) {
    return left.getId().equals(right.getId())
        && left.getUuid().equals(right.getUuid())
        && left.getCountryCode().equals(right.getCountryCode())
        && left.getAreaCode().equals(right.getAreaCode())
        && left.getNumber().equals(right.getNumber())
        && left.getExtension() == right.getExtension();
  }
}
