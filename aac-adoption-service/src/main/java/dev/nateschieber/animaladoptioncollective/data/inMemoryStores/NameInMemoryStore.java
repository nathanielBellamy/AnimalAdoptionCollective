package dev.nateschieber.animaladoptioncollective.data.inMemoryStores;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.INameDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Name;
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
public class NameInMemoryStore implements INameDataAccessor{
  @Override
  public void flush() {

  }

  @Override
  public <S extends Name> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends Name> List<S> saveAllAndFlush(Iterable<S> entities) {
    return List.of();
  }

  @Override
  public void deleteAllInBatch(Iterable<Name> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> longs) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public Name getOne(Long aLong) {
    return null;
  }

  @Override
  public Name getById(Long aLong) {
    return null;
  }

  @Override
  public Name getReferenceById(Long aLong) {
    return null;
  }

  @Override
  public <S extends Name> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Name> List<S> findAll(Example<S> example) {
    return List.of();
  }

  @Override
  public <S extends Name> List<S> findAll(Example<S> example, Sort sort) {
    return List.of();
  }

  @Override
  public <S extends Name> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Name> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Name> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Name, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

  @Override
  public <S extends Name> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Name> List<S> saveAll(Iterable<S> entities) {
    return List.of();
  }

  @Override
  public Optional<Name> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public List<Name> findAll() {
    return List.of();
  }

  @Override
  public List<Name> findAllById(Iterable<Long> longs) {
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
  public void delete(Name entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Name> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public List<Name> findAll(Sort sort) {
    return List.of();
  }

  @Override
  public Page<Name> findAll(Pageable pageable) {
    return null;
  }
}
