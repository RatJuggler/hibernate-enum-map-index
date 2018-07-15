package com.rj.hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Damage {

  private Integer multiplier;

  public Damage() {}

  public Damage(Integer multiplier) {
    this.multiplier = multiplier;
  }

  public Integer getMultiplier() {
    return multiplier;
  }

  public void setMultiplier(Integer multiplier) {
    this.multiplier = multiplier;
  }

  @Override
  public String toString() {
    return "Damage{multiplier=" + multiplier + '}';
  }

}
