package dev.nateschieber.animaladoptioncollective.rest.responses;

import dev.nateschieber.animaladoptioncollective.enums.ApiVersion;
import dev.nateschieber.animaladoptioncollective.gratitude.Gratitude;
import java.time.LocalDateTime;

public abstract class AacHttpResponse {
  private ApiVersion apiVersion = ApiVersion.V1;
  private LocalDateTime responseAt = LocalDateTime.now();
  private String momentOfGratitude = Gratitude.randomMoment();

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
