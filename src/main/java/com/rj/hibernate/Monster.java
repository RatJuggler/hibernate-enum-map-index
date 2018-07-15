package com.rj.hibernate;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.MapKeyType;
import org.hibernate.annotations.Type;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Monster.getAll", query = "SELECT m FROM Monster m") })
public class Monster {

  @Id
  private Integer id;
  private String name;

  @Type(type = "com.rj.hibernate.SizeType")
  private Size size;

  @ElementCollection
  @CollectionTable(name = "Damage", joinColumns = @JoinColumn(name = "monsterid"))
  @MapKeyType(@Type(type = "com.rj.hibernate.AttackType"))
  @MapKeyColumn(name = "attack")
  private Map<Attack, Damage> attacks = new HashMap<>();

  public Monster() {}

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

  public Map<Attack, Damage> getAttacks() {
    return attacks;
  }

  public Damage getAttack(Attack attack) {
    return attacks.get(attack);
  }

  public void addAttack(Attack attack, Damage damage) {
    attacks.put(attack, damage);
  }

  @Override
  public String toString() {
    String monster = "\nMonster{" + "id=" + id + ", name='" + name + "\', size=" + size + '}';
    for (Damage damage : attacks.values()) {
      monster += "\n- " + damage;
    }
    return monster;
  }

}
