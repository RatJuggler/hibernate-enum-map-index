package com.rj.hibernate;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.IntegerTypeDescriptor;

public class SizeType extends AbstractSingleColumnStandardBasicType<Size> {

  private static final long serialVersionUID = 1L;

  public static final SizeType INSTANCE = new SizeType();

  public SizeType() {
    super(IntegerTypeDescriptor.INSTANCE, SizeJavaTypeDescriptor.INSTANCE);
  }

  @Override
  public String getName() {
    return "size";
  }

  @Override
  protected boolean registerUnderJavaType() {
    return true;
  }

}
