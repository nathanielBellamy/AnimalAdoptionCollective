package dev.nateschieber.animaladoptioncollective.rest.dtos.note.send;

import dev.nateschieber.animaladoptioncollective.entities.Note;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.NoteDto;

public record NoteEntityDto(Note note) implements NoteDto {}
