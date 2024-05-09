package dev.nateschieber.animaladoptioncollective.daos.interfaces;

import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public interface IPhoneNumberDataAccessor {
  void flush();

  <S extends PhoneNumber> S saveAndFlush(S entity);

  <S extends PhoneNumber> List<S> saveAllAndFlush(Iterable<S> entities);

  void deleteAllInBatch(Iterable<PhoneNumber> entities);

  void deleteAllByIdInBatch(Iterable<Long> longs);

  void deleteAllInBatch();

  PhoneNumber getOne(Long aLong);

  PhoneNumber getById(Long aLong);

  PhoneNumber getReferenceById(Long aLong);

  <S extends PhoneNumber> Optional<S> findOne(Example<S> example);

  <S extends PhoneNumber> List<S> findAll(Example<S> example);

  <S extends PhoneNumber> List<S> findAll(Example<S> example, Sort sort);

  <S extends PhoneNumber> Page<S> findAll(Example<S> example, Pageable pageable);

  <S extends PhoneNumber> long count(Example<S> example);

  <S extends PhoneNumber> boolean exists(Example<S> example);

  <S extends PhoneNumber, R> R findBy(
      Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

  <S extends PhoneNumber> S save(S entity);

  <S extends PhoneNumber> List<S> saveAll(Iterable<S> entities);

  Optional<PhoneNumber> findById(Long aLong);

  boolean existsById(Long aLong);

  List<PhoneNumber> findAll();

  List<PhoneNumber> findAllById(Iterable<Long> longs);

  long count();

  void deleteById(Long aLong);

  void delete(PhoneNumber entity);

  void deleteAllById(Iterable<? extends Long> longs);

  void deleteAll(Iterable<? extends PhoneNumber> entities);

  void deleteAll();

  List<PhoneNumber> findAll(Sort sort);

  Page<PhoneNumber> findAll(Pageable pageable);
}
