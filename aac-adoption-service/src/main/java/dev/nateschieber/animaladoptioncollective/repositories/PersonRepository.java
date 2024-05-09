package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.daos.interfaces.IPersonDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>, IPersonDataAccessor { }
