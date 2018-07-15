package com.rj.hibernate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Damage {

  @Id
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "MONSTERID", nullable = false)
  private Monster monster;

  @Convert(converter = AttackConverter.class)
  private Attack attack;

  private Integer multiplier;

  public Damage() {}

  public Damage(Integer id, Attack attack, Integer multiplier) {
    this.id = id;
    this.attack = attack;
    this.multiplier = multiplier;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Monster getMonster() {
    return monster;
  }

  public void setMonster(Monster monster) {
    this.monster = monster;
  }

  public Attack getAttack() {
    return attack;
  }

  public void setAttack(Attack attack) {
    this.attack = attack;
  }

  public Integer getMultiplier() {
    return multiplier;
  }

  public void setMultiplier(Integer multiplier) {
    this.multiplier = multiplier;
  }

  @Override
  public String toString() {
    return "Damage{" + "id=" + id + ", attack=" + attack + ", multiplier=" + multiplier + '}';
  }

}
