package com.rj.hibernate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
  @NamedQuery(name = "Monster.getAll", query = "SELECT m FROM Monster m")
})
public class Monster {

  @Id
  private Integer id;
  private String name;

  @Enumerated(EnumType.ORDINAL)
  private Size size;

  public Monster() {
  }

  public Monster(Integer id, String name, Size size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Monster{" + "id=" + id + ", name='" + name + "\', size=" + size + '}';
  }

}
