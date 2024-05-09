package dev.nateschieber.animaladoptioncollective.data.inMemoryStores;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPhoneNumberDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberInMemoryStore implements IPhoneNumberDataAccessor {
  @Override
  public void flush() {

  }

  @Override
  public <S extends PhoneNumber> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends PhoneNumber> List<S> saveAllAndFlush(Iterable<S> entities) {
    return List.of();
  }

  @Override
  public void deleteAllInBatch(Iterable<PhoneNumber> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> longs) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public PhoneNumber getOne(Long aLong) {
    return null;
  }

  @Override
  public PhoneNumber getById(Long aLong) {
    return null;
  }

  @Override
  public PhoneNumber getReferenceById(Long aLong) {
    return null;
  }

  @Override
  public <S extends PhoneNumber> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends PhoneNumber> List<S> findAll(Example<S> example) {
    return List.of();
  }

  @Override
  public <S extends PhoneNumber> List<S> findAll(Example<S> example, Sort sort) {
    return List.of();
  }

  @Override
  public <S extends PhoneNumber> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends PhoneNumber> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends PhoneNumber> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends PhoneNumber, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

  @Override
  public <S extends PhoneNumber> S save(S entity) {
    return null;
  }

  @Override
  public <S extends PhoneNumber> List<S> saveAll(Iterable<S> entities) {
    return List.of();
  }

  @Override
  public Optional<PhoneNumber> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public List<PhoneNumber> findAll() {
    return List.of();
  }

  @Override
  public List<PhoneNumber> findAllById(Iterable<Long> longs) {
    return List.of();
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public void delete(PhoneNumber entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends PhoneNumber> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public List<PhoneNumber> findAll(Sort sort) {
    return List.of();
  }

  @Override
  public Page<PhoneNumber> findAll(Pageable pageable) {
    return null;
  }
}
