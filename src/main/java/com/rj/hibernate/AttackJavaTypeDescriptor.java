package com.rj.hibernate;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.IntegerTypeDescriptor;

public class AttackJavaTypeDescriptor extends AbstractTypeDescriptor<Attack> {

  private static final long serialVersionUID = 1L;

  public static final AttackJavaTypeDescriptor INSTANCE = new AttackJavaTypeDescriptor();

  protected AttackJavaTypeDescriptor() {
    super(Attack.class);
  }

  @Override
  public String toString(Attack value) {
    return value == null ? null : value.name();
  }

  @Override
  public Attack fromString(String string) {
    return string == null ? null : Attack.valueOf(string);
  }

  @Override
  public <X> X unwrap(Attack value, Class<X> type, WrapperOptions options) {
    return IntegerTypeDescriptor.INSTANCE.unwrap(value == null ? null : value.getCode(), type, options);
  }

  @Override
  public <X> Attack wrap(X value, WrapperOptions options) {
    return Attack.fromCode(IntegerTypeDescriptor.INSTANCE.wrap(value, options));
  }

}
