package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Note;
import dev.nateschieber.animaladoptioncollective.repositories.NoteRepository;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
  private final NoteRepository noteRepository;

  @Autowired
  public NoteService(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  public Note save(Note note) {
    return noteRepository.save(note);
  }

  public List<Note> saveAll(List<Note> notes) {
    return noteRepository.saveAll(notes);
  }

  public Note createFromDto(NoteCreateDto dto) {
    Note note = new Note(dto);
    return noteRepository.save(note);
  }
}
