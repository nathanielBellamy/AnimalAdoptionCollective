package dev.nateschieber.animaladoptioncollective.data.jpaRepositories;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.INameDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNameRepository extends JpaRepository<Name, Long>, INameDataAccessor { }
