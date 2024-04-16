package dev.nateschieber.animaladoptioncollective.rest.responses.adoption;

import dev.nateschieber.animaladoptioncollective.enums.ApiVersion;
import dev.nateschieber.animaladoptioncollective.gratitude.Gratitude;
import dev.nateschieber.animaladoptioncollective.rest.dtos.adoption.AdoptionDto;
import java.time.LocalDateTime;

public abstract class AdoptionResponse {
  private AdoptionDto data;
  private ApiVersion apiVersion = ApiVersion.V1;
  private LocalDateTime responseAt = LocalDateTime.now();
  private String momentOfGratitude = Gratitude.randomMoment();

  public AdoptionDto getData() {
    return data;
  }

  public void setData(AdoptionDto data) {
    this.data = data;
  }

  public ApiVersion getApiVersion() {
    return apiVersion;
  }

  public LocalDateTime getResponseAt() {
    return responseAt;
  }

  public String getMomentOfGratitude() {
    return momentOfGratitude;
  }
}
