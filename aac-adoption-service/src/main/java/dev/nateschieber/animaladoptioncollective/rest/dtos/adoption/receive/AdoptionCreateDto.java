package dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive;

import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public record AdoptionCreateDto(
    LocalDate dateOfAdoption,
    List<NoteCreateDto> notes,
    @Size(min = 1)
    List<Long> personIds,
    @NotNull
    Long petId
) implements AdoptionDto { }
