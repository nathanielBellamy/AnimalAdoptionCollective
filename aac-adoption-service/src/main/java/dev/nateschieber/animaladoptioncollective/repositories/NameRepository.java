package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.daoInterfaces.INameDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name, Long>, INameDataAccessor { }
