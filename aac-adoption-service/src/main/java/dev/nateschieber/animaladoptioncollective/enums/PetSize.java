package dev.nateschieber.animaladoptioncollective.enums;

public enum PetSize {
  XXS(0, 10),
  XS(10, 20),
  S(20, 30),
  M(30, 50),
  L(60, 120),
  XL(120, 200),
  XXL(200, null);

  private int minWeightLbs;
  private Integer maxWeightLbs;

  private PetSize(int minWeightLbs, Integer maxWeightLbs) {
    this.minWeightLbs = minWeightLbs;
    this.maxWeightLbs = maxWeightLbs;
  }

  public int getMinWeightLbs() {
    return this.minWeightLbs;
  }

  public int getMaxWeightLbs() {
    return this.maxWeightLbs;
  }
}
