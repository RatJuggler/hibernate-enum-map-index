package com.rj.hibernate;

public enum Attack {

  ROAR(5),
  BITE(0),
  CLAW(1),
  STOMP(2),
  MISCHIEF(3),
  RADIOACTIVE_FIRE(4);

  private Integer code;

  private Attack(Integer code) {
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }

  public static Attack fromCode(Integer code) {
    switch (code) {
    case 5:
      return Attack.ROAR;

    case 0:
      return Attack.BITE;

    case 1:
      return Attack.CLAW;

    case 2:
      return Attack.STOMP;

    case 3:
      return Attack.MISCHIEF;

    case 4:
      return Attack.RADIOACTIVE_FIRE;

    default:
      throw new IllegalArgumentException("Code [" + code + "] not supported.");
    }
  }

}
