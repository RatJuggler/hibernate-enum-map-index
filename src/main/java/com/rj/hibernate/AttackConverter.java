package com.rj.hibernate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AttackConverter implements AttributeConverter<Attack, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Attack size) {
    return size.getCode();
  }

  @Override
  public Attack convertToEntityAttribute(Integer code) {
    return Attack.fromCode(code);
  }

}
