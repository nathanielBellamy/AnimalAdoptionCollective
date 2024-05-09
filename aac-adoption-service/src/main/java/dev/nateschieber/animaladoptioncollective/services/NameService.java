package dev.nateschieber.animaladoptioncollective.services;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.INameDataAccessor;
import dev.nateschieber.animaladoptioncollective.data.daos.NameDao;
import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameService {

  private final INameDataAccessor dao;

  @Autowired
  public NameService(NameDao nameDao) {
    this.dao = nameDao.runtime;
  }

  public List<Name> findAll() {
    return dao.findAll();
  }

  public Name save(Name name) {
    return dao.save(name);
  }

  public Name createFromDto(NameCreateDto dto) {
    Name name = new Name(dto);
    return dao.save(name);
  }
}
