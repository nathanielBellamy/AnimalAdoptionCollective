package dev.nateschieber.animaladoptioncollective.gratitude;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Gratitude {
  private static List<String> moments;

  static {
      moments = List.of(
        "Do something today that your future self will thank you for. — Sean Patrick Flanery",
          "Appreciate the lovers rather than acknowledging the haters. — Sophia L Skaalerud",
          "When we focus on our gratitude, the tide of disappointment goes out and the tide of love rushes in. — Kristin Armstrong",
          "Reflect upon your present blessings, of which every man has many - not on your past misfortunes, of which all men have some. - Charles Dickens",
          "Gratitude and attitude are not challenges; they are choices. — Robert Braathe",
          "A grateful mind is a great mind which eventually attracts to itself great things. — Plato",
          "Be thankful for what you have; you'll end up having more. If you concentrate on what you don't have, you will never, ever have enough. — Oprah Winfrey",
          "However vast the darkness, we must supply it with our own light. — Stanley Kubrick",
          "This is a wonderful day. I have never seen this one before. — Maya Angelou"
      );
  }

  public static String randomMoment () {
    int index = randomInt(0, Gratitude.moments.size());
    return Gratitude.moments.get(index);
  }

  public static int randomInt(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max);
  }
}
