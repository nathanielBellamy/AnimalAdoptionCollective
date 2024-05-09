package dev.nateschieber.animaladoptioncollective.daos.interfaces;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public interface IAdoptionDataAccessor {
  void flush();

  <S extends Adoption> S saveAndFlush(S entity);

  <S extends Adoption> List<S> saveAllAndFlush(Iterable<S> entities);

  void deleteAllInBatch(Iterable<Adoption> entities);

  void deleteAllByIdInBatch(Iterable<Long> longs);

  void deleteAllInBatch();

  Adoption getOne(Long aLong);

  Adoption getById(Long aLong);

  Adoption getReferenceById(Long aLong);

  <S extends Adoption> Optional<S> findOne(Example<S> example);

  <S extends Adoption> List<S> findAll(Example<S> example);

  <S extends Adoption> List<S> findAll(Example<S> example, Sort sort);

  <S extends Adoption> Page<S> findAll(Example<S> example, Pageable pageable);

  <S extends Adoption> long count(Example<S> example);

  <S extends Adoption> boolean exists(Example<S> example);

  <S extends Adoption, R> R findBy(
      Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

  <S extends Adoption> S save(S entity);

  <S extends Adoption> List<S> saveAll(Iterable<S> entities);

  Optional<Adoption> findById(Long aLong);

  boolean existsById(Long aLong);

  List<Adoption> findAll();

  List<Adoption> findAllById(Iterable<Long> longs);

  long count();

  void deleteById(Long aLong);

  void delete(Adoption entity);

  void deleteAllById(Iterable<? extends Long> longs);

  void deleteAll(Iterable<? extends Adoption> entities);

  void deleteAll();

  List<Adoption> findAll(Sort sort);

  Page<Adoption> findAll(Pageable pageable);
}
