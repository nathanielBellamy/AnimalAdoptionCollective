package dev.nateschieber.animaladoptioncollective.data.jpaRepositories;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.INoteDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNoteRepository extends JpaRepository<Note, Long>, INoteDataAccessor {
}
