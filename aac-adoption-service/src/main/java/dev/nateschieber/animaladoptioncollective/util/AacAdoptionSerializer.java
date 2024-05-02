package dev.nateschieber.animaladoptioncollective.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class AacAdoptionSerializer {
  private static final ObjectWriter writer;

  static {
    ObjectMapper om = new ObjectMapper();
    writer = om.registerModule(new JavaTimeModule()).writer();
  }

  public static ObjectWriter getWriter() {
    return writer;
  }
}
