package dev.nateschieber.animaladoptioncollective.matchers;

import dev.nateschieber.animaladoptioncollective.entities.Person;
import java.util.stream.IntStream;
import org.mockito.ArgumentMatcher;

public class PersonMatcher implements ArgumentMatcher<Person> {

  public Person left;

  public PersonMatcher(Person person) { left = person; }

  @Override
  public boolean matches(Person right) {
    return left.getId().equals(right.getId())
        && left.getUuid().equals(right.getUuid())
        && new NameMatcher(left.getName()).matches(right.getName())
        && left.getDateJoined().equals(right.getDateJoined())
        && IntStream
        .range(0, left.getPhoneNumbers().size())
        .allMatch(idx -> new PhoneNumberMatcher(left.getPhoneNumbers().get(idx)).matches(right.getPhoneNumbers().get(idx)));
  }
}
