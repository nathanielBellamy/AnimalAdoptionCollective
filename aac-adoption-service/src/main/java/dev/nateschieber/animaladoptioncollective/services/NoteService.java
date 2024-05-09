package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.data.daos.NoteDao;
import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.INoteDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Note;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
  private final INoteDataAccessor noteDao;

  @Autowired
  public NoteService(NoteDao noteDao) {
    this.noteDao = noteDao.runtime;
  }

  public Note save(Note note) {
    return noteDao.save(note);
  }

  public List<Note> saveAll(List<Note> notes) {
    return noteDao.saveAll(notes);
  }

  public Note createFromDto(NoteCreateDto dto) {
    Note note = new Note(dto);
    return noteDao.save(note);
  }
}
