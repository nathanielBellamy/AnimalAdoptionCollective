package dev.nateschieber.animaladoptioncollective.rest.responses.note;

import dev.nateschieber.animaladoptioncollective.rest.dtos.note.NoteDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.AacHttpResponse;

public abstract class NoteResponse extends AacHttpResponse {
  public NoteDto getData() {
    return data;
  }

  public void setData(NoteDto data) {
    this.data = data;
  }

  private NoteDto data;

}
