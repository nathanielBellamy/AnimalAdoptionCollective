package dev.nateschieber.animaladoptioncollective.matchers;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import lombok.val;
import org.mockito.ArgumentMatcher;

public class AdoptionMatcher implements ArgumentMatcher<Adoption> {

  private Adoption left;

  public AdoptionMatcher(Adoption adoption) { left = adoption; }

  @Override
  public boolean matches(Adoption right) {
    val idsMatch = left.getId() == right.getId();
    val uuidsMatch = left.getUuid().equals(right.getUuid());
    val personsMatch = personsMatch(left, right);
    val datesMatch = left.getDateOfAdoption().equals(right.getDateOfAdoption());
    val petsMatch = new PetMatcher(left.getPet()).matches(right.getPet());

    return idsMatch
        && uuidsMatch
        && personsMatch
        && datesMatch
        && petsMatch;
  }

  private boolean personsMatch(Adoption left, Adoption right) {
    List<Person> leftPersons = left.getPersons().stream().sorted(Comparator.comparingLong(Person::getId)).toList();
    List<Person> rightPersons = right.getPersons().stream().sorted(Comparator.comparingLong(Person::getId)).toList();

    val res = IntStream
        .range(0, leftPersons.size())
        .mapToObj(idx -> new PersonMatcher(leftPersons.get(idx)).matches(rightPersons.get(idx)))
        .allMatch(bool -> bool);

    return res;
  }
}
