package dev.nateschieber.animaladoptioncollective.data.jpaRepositories;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IAdoptionDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAdoptionRepository extends JpaRepository<Adoption, Long>, IAdoptionDataAccessor { }
