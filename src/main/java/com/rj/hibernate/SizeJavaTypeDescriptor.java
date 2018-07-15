package com.rj.hibernate;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.IntegerTypeDescriptor;

public class SizeJavaTypeDescriptor extends AbstractTypeDescriptor<Size> {

  private static final long serialVersionUID = 1L;

  public static final SizeJavaTypeDescriptor INSTANCE = new SizeJavaTypeDescriptor();

  protected SizeJavaTypeDescriptor() {
    super(Size.class);
  }

  public String toString(Size value) {
    return value == null ? null : value.name();
  }

  public Size fromString(String string) {
    return string == null ? null : Size.valueOf(string);
  }

  public <X> X unwrap(Size value, Class<X> type, WrapperOptions options) {
    return IntegerTypeDescriptor.INSTANCE.unwrap(value == null ? null : value.getCode(), type, options);
  }

  public <X> Size wrap(X value, WrapperOptions options) {
    return Size.fromCode(IntegerTypeDescriptor.INSTANCE.wrap(value, options));
  }

}
