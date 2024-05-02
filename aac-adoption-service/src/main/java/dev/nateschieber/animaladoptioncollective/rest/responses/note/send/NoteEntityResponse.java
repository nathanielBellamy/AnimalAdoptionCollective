package dev.nateschieber.animaladoptioncollective.rest.responses.note.send;

import dev.nateschieber.animaladoptioncollective.entities.Note;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.send.NoteEntityDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.note.NoteResponse;

public class NoteEntityResponse extends NoteResponse {
  public NoteEntityResponse(Note note) {
    this.setData( new NoteEntityDto(note));
  }
}
