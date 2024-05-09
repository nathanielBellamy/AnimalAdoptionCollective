package dev.nateschieber.animaladoptioncollective.data.daos.interfaces;

import dev.nateschieber.animaladoptioncollective.entities.Person;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public interface IPersonDataAccessor {
  void flush();

  <S extends Person> S saveAndFlush(S entity);

  <S extends Person> List<S> saveAllAndFlush(Iterable<S> entities);

  void deleteAllInBatch(Iterable<Person> entities);

  void deleteAllByIdInBatch(Iterable<Long> longs);

  void deleteAllInBatch();

  Person getOne(Long aLong);

  Person getById(Long aLong);

  Person getReferenceById(Long aLong);

  <S extends Person> Optional<S> findOne(Example<S> example);

  <S extends Person> List<S> findAll(Example<S> example);

  <S extends Person> List<S> findAll(Example<S> example, Sort sort);

  <S extends Person> Page<S> findAll(Example<S> example, Pageable pageable);

  <S extends Person> long count(Example<S> example);

  <S extends Person> boolean exists(Example<S> example);

  <S extends Person, R> R findBy(
      Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

  <S extends Person> S save(S entity);

  <S extends Person> List<S> saveAll(Iterable<S> entities);

  Optional<Person> findById(Long aLong);

  boolean existsById(Long aLong);

  List<Person> findAll();

  List<Person> findAllById(Iterable<Long> longs);

  long count();

  void deleteById(Long aLong);

  void delete(Person entity);

  void deleteAllById(Iterable<? extends Long> longs);

  void deleteAll(Iterable<? extends Person> entities);

  void deleteAll();

  List<Person> findAll(Sort sort);

  Page<Person> findAll(Pageable pageable);
}
