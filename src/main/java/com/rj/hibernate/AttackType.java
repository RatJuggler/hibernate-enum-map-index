package com.rj.hibernate;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.IntegerTypeDescriptor;

public class AttackType extends AbstractSingleColumnStandardBasicType<Attack> {

  private static final long serialVersionUID = 1L;

  public static final AttackType INSTANCE = new AttackType();

  public AttackType() {
    super(IntegerTypeDescriptor.INSTANCE, AttackJavaTypeDescriptor.INSTANCE);
  }

  @Override
  public String getName() {
    return "attack";
  }

  @Override
  protected boolean registerUnderJavaType() {
    return true;
  }

}
