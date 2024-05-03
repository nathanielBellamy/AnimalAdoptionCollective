package dev.nateschieber.animaladoptioncollective.rest.dtos.person.receive;

import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.note.receive.NoteCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.person.PersonDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.phoneNumber.receive.PhoneNumberCreateDto;
import java.time.LocalDate;
import java.util.List;

public record PersonCreateDto(
    LocalDate dateJoined,
    NameCreateDto name,
    List<PhoneNumberCreateDto> phoneNumbers,
    List<NoteCreateDto> notes
) implements PersonDto {}
