package dev.nateschieber.animaladoptioncollective.daoInterfaces;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public interface INameDataAccessor {
  void flush();

  <S extends Name> S saveAndFlush(S entity);

  <S extends Name> List<S> saveAllAndFlush(Iterable<S> entities);

  void deleteAllInBatch(Iterable<Name> entities);

  void deleteAllByIdInBatch(Iterable<Long> longs);

  void deleteAllInBatch();

  Name getOne(Long aLong);

  Name getById(Long aLong);

  Name getReferenceById(Long aLong);

  <S extends Name> Optional<S> findOne(Example<S> example);

  <S extends Name> List<S> findAll(Example<S> example);

  <S extends Name> List<S> findAll(Example<S> example, Sort sort);

  <S extends Name> Page<S> findAll(Example<S> example, Pageable pageable);

  <S extends Name> long count(Example<S> example);

  <S extends Name> boolean exists(Example<S> example);

  <S extends Name, R> R findBy(
      Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

  <S extends Name> S save(S entity);

  <S extends Name> List<S> saveAll(Iterable<S> entities);

  Optional<Name> findById(Long aLong);

  boolean existsById(Long aLong);

  List<Name> findAll();

  List<Name> findAllById(Iterable<Long> longs);

  long count();

  void deleteById(Long aLong);

  void delete(Name entity);

  void deleteAllById(Iterable<? extends Long> longs);

  void deleteAll(Iterable<? extends Name> entities);

  void deleteAll();

  List<Name> findAll(Sort sort);

  Page<Name> findAll(Pageable pageable);
}
