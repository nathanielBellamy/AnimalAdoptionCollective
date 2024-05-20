package dev.nateschieber.animaladoptioncollective.data.jpaRepositories;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPersonDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonRepository extends JpaRepository<Person, Long>, IPersonDataAccessor { }
