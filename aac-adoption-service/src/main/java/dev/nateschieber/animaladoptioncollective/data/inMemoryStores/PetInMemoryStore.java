package dev.nateschieber.animaladoptioncollective.data.inMemoryStores;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPetDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Pet;
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
public class PetInMemoryStore implements IPetDataAccessor {
  @Override
  public void flush() {

  }

  @Override
  public <S extends Pet> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends Pet> List<S> saveAllAndFlush(Iterable<S> entities) {
    return List.of();
  }

  @Override
  public void deleteAllInBatch(Iterable<Pet> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> longs) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public Pet getOne(Long aLong) {
    return null;
  }

  @Override
  public Pet getById(Long aLong) {
    return null;
  }

  @Override
  public Pet getReferenceById(Long aLong) {
    return null;
  }

  @Override
  public <S extends Pet> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Pet> List<S> findAll(Example<S> example) {
    return List.of();
  }

  @Override
  public <S extends Pet> List<S> findAll(Example<S> example, Sort sort) {
    return List.of();
  }

  @Override
  public <S extends Pet> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Pet> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Pet> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Pet, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

  @Override
  public <S extends Pet> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Pet> List<S> saveAll(Iterable<S> entities) {
    return List.of();
  }

  @Override
  public Optional<Pet> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public List<Pet> findAll() {
    return List.of();
  }

  @Override
  public List<Pet> findAllById(Iterable<Long> longs) {
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
  public void delete(Pet entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Pet> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public List<Pet> findAll(Sort sort) {
    return List.of();
  }

  @Override
  public Page<Pet> findAll(Pageable pageable) {
    return null;
  }
}
