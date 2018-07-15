package com.rj.hibernate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SizeConverter implements AttributeConverter<Size, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Size size) {
    return size.getCode();
  }

  @Override
  public Size convertToEntityAttribute(Integer code) {
    return Size.fromCode(code);
  }

}
