package dev.nateschieber.animaladoptioncollective.mockData;

import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.enums.PhoneNumberType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.receive.PersonCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.receive.PhoneNumberCreateDto;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

public class MockPersonFactory {

  public static List<Person> defaultPersons() {
    List<Person> mockPersons = MockPersonFactory.defaultPersonCreateDtos()
        .stream()
        .map(dto -> new Person(dto))
        .toList();

    return IntStream
        .range(0, mockPersons.size())
        .mapToObj(i -> {
          Person person = mockPersons.get(i);
          person.setId(i + 1l);
          return person;
        }).toList();
  }

  public static List<PersonCreateDto> defaultPersonCreateDtos() {
    return List.of(
        new PersonCreateDto(
            LocalDate.now(),
            new NameCreateDto(EntityType.PERSON, "Steve", "", "Holt", "Steve"),
            List.of(
                new PhoneNumberCreateDto(1, 212, 5551234, null, PhoneNumberType.MOBILE, false)
            ),
            List.of(
                new NoteCreateDto("Steve Holt!")
            )
        ),
        new PersonCreateDto(
            LocalDate.now(),
            new NameCreateDto(EntityType.PERSON, "Lucas", "", "Skywalker", "Luke"),
            List.of(
                new PhoneNumberCreateDto(1, 212, 5554321, null, PhoneNumberType.WORK, false)
            ),
            List.of(
                new NoteCreateDto("Uses the force")
            )
        ),
        new PersonCreateDto(
            LocalDate.now(),
            new NameCreateDto(EntityType.PERSON, "Theodore", "", "Roosevelt", "Teddy"),
            List.of(
                new PhoneNumberCreateDto(1, 212, 5552222, null, PhoneNumberType.HOME, false)
            ),
            List.of(
                new NoteCreateDto("Walk softly and carry a big stick")
            )
        )
    );
  }
}
