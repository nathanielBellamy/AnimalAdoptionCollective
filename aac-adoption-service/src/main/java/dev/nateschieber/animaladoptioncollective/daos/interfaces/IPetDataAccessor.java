package dev.nateschieber.animaladoptioncollective.daos.interfaces;

import dev.nateschieber.animaladoptioncollective.entities.Pet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public interface IPetDataAccessor {
  void flush();

  <S extends Pet> S saveAndFlush(S entity);

  <S extends Pet> List<S> saveAllAndFlush(Iterable<S> entities);

  void deleteAllInBatch(Iterable<Pet> entities);

  void deleteAllByIdInBatch(Iterable<Long> longs);

  void deleteAllInBatch();

  Pet getOne(Long aLong);

  Pet getById(Long aLong);

  Pet getReferenceById(Long aLong);

  <S extends Pet> Optional<S> findOne(Example<S> example);

  <S extends Pet> List<S> findAll(Example<S> example);

  <S extends Pet> List<S> findAll(Example<S> example, Sort sort);

  <S extends Pet> Page<S> findAll(Example<S> example, Pageable pageable);

  <S extends Pet> long count(Example<S> example);

  <S extends Pet> boolean exists(Example<S> example);

  <S extends Pet, R> R findBy(
      Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

  <S extends Pet> S save(S entity);

  <S extends Pet> List<S> saveAll(Iterable<S> entities);

  Optional<Pet> findById(Long aLong);

  boolean existsById(Long aLong);

  List<Pet> findAll();

  List<Pet> findAllById(Iterable<Long> longs);

  long count();

  void deleteById(Long aLong);

  void delete(Pet entity);

  void deleteAllById(Iterable<? extends Long> longs);

  void deleteAll(Iterable<? extends Pet> entities);

  void deleteAll();

  List<Pet> findAll(Sort sort);

  Page<Pet> findAll(Pageable pageable);
}
