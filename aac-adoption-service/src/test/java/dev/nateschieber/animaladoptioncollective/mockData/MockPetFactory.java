package dev.nateschieber.animaladoptioncollective.mockData;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.enums.EntityType;
import dev.nateschieber.animaladoptioncollective.enums.PetSize;
import dev.nateschieber.animaladoptioncollective.enums.PetType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.receive.PetCreateDto;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

public class MockPetFactory {

  public static List<Pet> defaultPets() {

    List<Pet> mockPets = List.of(
      new Pet( new PetCreateDto(
          PetType.TURTLE,
          PetSize.XL,
          "Teenage Mutant Ninja",
          new NameCreateDto(EntityType.PET, "Michelangelo", "", "", ""),
          LocalDate.of(1985, 1, 1),
          LocalDate.of(1990, 1, 1),
          List.of(
              new NoteCreateDto("Kowabunga")
          )
      )),
      new Pet( new PetCreateDto(
          PetType.DOG,
          PetSize.XL,
          "Big Red",
          new NameCreateDto(EntityType.PET, "Clifford", "", "", ""),
          LocalDate.of(1985, 1, 1),
          LocalDate.of(1990, 1, 1),
          List.of(
              new NoteCreateDto("Is a good boy")
          )
      )),
        new Pet( new PetCreateDto(
            PetType.CAT,
            PetSize.L,
            "Orange Tabby Persian",
            new NameCreateDto(EntityType.PET, "Garfield", "", "", ""),
            LocalDate.of(1983, 1, 1),
            LocalDate.of(1998, 1, 1),
            List.of(
                new NoteCreateDto("Likes lasagna")
            )
        ))
    );

    return IntStream
        .range(0, mockPets.size())
        .mapToObj(i -> {
          Pet pet = mockPets.get(i);
          pet.setId(i + 1l);
          return pet;
        }).toList();
  }
}
