package com.rj.hibernate;

public enum Attack {

  ROAR(Integer.valueOf(5)),
  BITE(Integer.valueOf(0)),
  CLAW(Integer.valueOf(1)),
  STOMP(Integer.valueOf(2)),
  MISCHIEF(Integer.valueOf(3)),
  RADIOACTIVE_FIRE(Integer.valueOf(4));

  private Integer code;

  private Attack(Integer code) {
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }

  public static Attack fromCode(Integer code) {
    switch (code.intValue()) {
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
