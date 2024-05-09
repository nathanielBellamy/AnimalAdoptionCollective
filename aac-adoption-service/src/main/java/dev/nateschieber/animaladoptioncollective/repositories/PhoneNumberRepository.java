package dev.nateschieber.animaladoptioncollective.repositories;

import dev.nateschieber.animaladoptioncollective.daos.interfaces.IPhoneNumberDataAccessor;
import dev.nateschieber.animaladoptioncollective.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long>, IPhoneNumberDataAccessor { }
