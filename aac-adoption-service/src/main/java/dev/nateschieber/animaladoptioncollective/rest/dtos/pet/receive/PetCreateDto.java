package dev.nateschieber.animaladoptioncollective.rest.dtos.pet.receive;

import dev.nateschieber.animaladoptioncollective.enums.PetSize;
import dev.nateschieber.animaladoptioncollective.enums.PetType;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.pet.PetDto;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record PetCreateDto(
    @NotNull
    PetType type,
    @NotNull
    PetSize size,
    String breed,
    NameCreateDto name,
    LocalDate dateOfIntake,
    LocalDate dateOfBirth,
    List<NoteCreateDto> notes
)
implements PetDto {}
