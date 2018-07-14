package com.rj.hibernate;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Monster.getAll", query = "SELECT m FROM Monster m") })
public class Monster {

  @Id
  private Integer id;
  private String name;

  @Enumerated(EnumType.ORDINAL)
  private Size size;

  @OneToMany(mappedBy = "monster", cascade = CascadeType.ALL, orphanRemoval = true)
  @MapKey(name = "attack")
  @MapKeyEnumerated
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

  public void addAttack(Damage damage) {
    damage.setMonster(this);
    attacks.put(damage.getAttack(), damage);
  }

  @Override
  public String toString() {
    String monster = "Monster{" + "id=" + id + ", name='" + name + "\', size=" + size + '}';
    for (Damage damage : attacks.values()) {
      monster += "\n- " + damage;
    }
    return monster;
  }

}
