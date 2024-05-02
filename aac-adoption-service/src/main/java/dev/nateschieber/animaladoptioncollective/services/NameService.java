package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.repositories.NameRepository;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameService {

  private final NameRepository repository;

  @Autowired
  public NameService(NameRepository repository) {
    this.repository = repository;
  }

  public Name createFromDto(NameCreateDto dto) {
    Name name = new Name(dto);
    return repository.save(name);
  }
}
