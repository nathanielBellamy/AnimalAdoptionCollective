package dev.nateschieber.animaladoptioncollective.data.jpaRepositories;

import dev.nateschieber.animaladoptioncollective.data.daos.interfaces.IPhoneNumberDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPhoneNumberRepository extends JpaRepository<PhoneNumber, Long>, IPhoneNumberDataAccessor { }
