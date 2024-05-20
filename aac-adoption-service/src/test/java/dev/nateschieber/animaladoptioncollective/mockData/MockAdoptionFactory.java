package dev.nateschieber.animaladoptioncollective.mockData;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.services.PetService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

public class MockAdoptionFactory {
  public static void main(String[] args) {
    // test

    System.out.println(MockAdoptionFactory.defaultAdoptions());
  }

  public static List<Adoption> defaultAdoptions() {
    List<AdoptionCreateDto> mockAdoptionCreateDtos = MockAdoptionFactory.defaultAdoptionCreateDtos();
    List<Adoption> mockAdoptions = mockAdoptionCreateDtos.stream().map(macd -> new Adoption(macd)).toList();

    return IntStream
        .range(0, mockAdoptions.size())
        .mapToObj(i -> {
          Adoption adoption = mockAdoptions.get(i);
          adoption.setId(i + 1l);
          return adoption;
        })
        .toList();
  }

    public static List<AdoptionCreateDto> defaultAdoptionCreateDtos() {
      return List.of(
          new AdoptionCreateDto(
              LocalDate.now(),
              List.of(
                  new NoteCreateDto("First!")
              ),
              List.of(1l),
              1l
          ),
          new AdoptionCreateDto(
              LocalDate.now(),
              List.of(
                  new NoteCreateDto("First!")
              ),
              List.of(2l),
              2l
          ),
          new AdoptionCreateDto(
              LocalDate.now(),
              List.of(
                  new NoteCreateDto("First!")
              ),
              List.of(1l, 2l),
              3l
          )
      );
    }
}
