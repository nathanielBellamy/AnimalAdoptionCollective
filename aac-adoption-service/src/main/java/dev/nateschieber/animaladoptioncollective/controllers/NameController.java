package dev.nateschieber.animaladoptioncollective.controllers;

import dev.nateschieber.animaladoptioncollective.entities.Adoption;
import dev.nateschieber.animaladoptioncollective.entities.Name;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.receive.AdoptionCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.dtos.name.receive.NameCreateDto;
import dev.nateschieber.animaladoptioncollective.rest.responses.adoption.AdoptionEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.adoption.send.AdoptionGetAllResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.name.send.NameEntityResponse;
import dev.nateschieber.animaladoptioncollective.rest.responses.name.send.NameGetAllResponse;
import dev.nateschieber.animaladoptioncollective.services.NameService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/names")
public class NameController {

  private final NameService nameService;

  @Autowired
  public NameController(NameService nameService) {
    this.nameService = nameService;
  }

  @GetMapping("")
  @ResponseBody
  public ResponseEntity getAll() {
    List<Name> names = nameService.findAll();
    return ResponseEntity.ok().body(new NameGetAllResponse(names));
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity createAdoption(@RequestBody NameCreateDto dto) {
    Name nameSaved = nameService.createFromDto(dto);
    if (nameSaved == null) {
      return ResponseEntity.internalServerError().build();
    }

    URI uri;
    try {
      uri = new URI("/names/" + nameSaved.getId());
    } catch (URISyntaxException e) {
      uri = null;
    }
    return ResponseEntity.created(uri).body(new NameEntityResponse(nameSaved));
  }
}
