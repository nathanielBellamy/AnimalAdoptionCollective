package dev.nateschieber.animaladoptioncollective.inMemoryStores;

import dev.nateschieber.animaladoptioncollective.daoInterfaces.IAdoptionDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
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
public class AdoptionInMemoryStore implements IAdoptionDataAccessor {

  @Override
  public void flush() {

  }

  @Override
  public <S extends Adoption> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends Adoption> List<S> saveAllAndFlush(Iterable<S> entities) {
    return List.of();
  }

  @Override
  public void deleteAllInBatch(Iterable<Adoption> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> longs) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public Adoption getOne(Long aLong) {
    return null;
  }

  @Override
  public Adoption getById(Long aLong) {
    return null;
  }

  @Override
  public Adoption getReferenceById(Long aLong) {
    return null;
  }

  @Override
  public <S extends Adoption> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Adoption> List<S> findAll(Example<S> example) {
    return List.of();
  }

  @Override
  public <S extends Adoption> List<S> findAll(Example<S> example, Sort sort) {
    return List.of();
  }

  @Override
  public <S extends Adoption> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Adoption> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Adoption> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Adoption, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

  @Override
  public <S extends Adoption> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Adoption> List<S> saveAll(Iterable<S> entities) {
    return List.of();
  }

  @Override
  public Optional<Adoption> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public List<Adoption> findAll() {
    return List.of();
  }

  @Override
  public List<Adoption> findAllById(Iterable<Long> longs) {
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
  public void delete(Adoption entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Adoption> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public List<Adoption> findAll(Sort sort) {
    return List.of();
  }

  @Override
  public Page<Adoption> findAll(Pageable pageable) {
    return null;
  }
}
