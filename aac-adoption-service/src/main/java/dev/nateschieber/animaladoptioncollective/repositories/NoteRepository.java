package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.daos.interfaces.INoteDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long>, INoteDataAccessor {
}
