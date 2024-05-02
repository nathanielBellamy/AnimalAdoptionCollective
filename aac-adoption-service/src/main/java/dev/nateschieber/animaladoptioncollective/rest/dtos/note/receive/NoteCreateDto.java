package dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive;

import dev.nateschieber.animaladoptioncollective.rest.dtos.note.NoteDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NoteCreateDto (
    @NotNull @Size(min = 3, max = 500)
    String body
) implements NoteDto {}
