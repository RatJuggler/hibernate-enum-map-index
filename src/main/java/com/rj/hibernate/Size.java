package com.rj.hibernate;

public enum Size {

  ENORMOUS(9),
  LARGE(0),
  MEDIUM(1),
  SMALL(2);

  private Integer code;

  private Size(Integer code) {
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }

  public static Size fromCode(Integer code) {
    switch (code) {
    case 9:
      return Size.ENORMOUS;

    case 0:
      return Size.LARGE;

    case 1:
      return Size.MEDIUM;

    case 2:
      return Size.SMALL;

    default:
      throw new IllegalArgumentException("Code [" + code + "] not supported.");
    }
  }

}
