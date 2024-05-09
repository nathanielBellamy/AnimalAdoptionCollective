package dev.nateschieber.animaladoptioncollective.daos.interfaces;

import dev.nateschieber.animaladoptioncollective.entities.Note;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public interface INoteDataAccessor {
  void flush();

  <S extends Note> S saveAndFlush(S entity);

  <S extends Note> List<S> saveAllAndFlush(Iterable<S> entities);

  void deleteAllInBatch(Iterable<Note> entities);

  void deleteAllByIdInBatch(Iterable<Long> longs);

  void deleteAllInBatch();

  Note getOne(Long aLong);

  Note getById(Long aLong);

  Note getReferenceById(Long aLong);

  <S extends Note> Optional<S> findOne(Example<S> example);

  <S extends Note> List<S> findAll(Example<S> example);

  <S extends Note> List<S> findAll(Example<S> example, Sort sort);

  <S extends Note> Page<S> findAll(Example<S> example, Pageable pageable);

  <S extends Note> long count(Example<S> example);

  <S extends Note> boolean exists(Example<S> example);

  <S extends Note, R> R findBy(
      Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

  <S extends Note> S save(S entity);

  <S extends Note> List<S> saveAll(Iterable<S> entities);

  Optional<Note> findById(Long aLong);

  boolean existsById(Long aLong);

  List<Note> findAll();

  List<Note> findAllById(Iterable<Long> longs);

  long count();

  void deleteById(Long aLong);

  void delete(Note entity);

  void deleteAllById(Iterable<? extends Long> longs);

  void deleteAll(Iterable<? extends Note> entities);

  void deleteAll();

  List<Note> findAll(Sort sort);

  Page<Note> findAll(Pageable pageable);
}
