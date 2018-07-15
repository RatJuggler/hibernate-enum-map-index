package com.rj.hibernate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class JPAHibernateCRUDTest extends JPAHibernateTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(JPAHibernateCRUDTest.class);

  private List<Monster> getAllMonsters() {
    return em.createNamedQuery("Monster.getAll", Monster.class).getResultList();
  }

  @Test
  public void testMonsterEntity1() {
    Monster monster = em.find(Monster.class, 1);
    LOGGER.info(monster.toString());
    assertNotNull(monster);
    assertEquals("Godzilla", monster.getName());
    assertEquals(Size.LARGE, monster.getSize());
    assertEquals(2, monster.getAttacks().size());
    monster.getAttacks().containsKey(Attack.STOMP);
    monster.getAttacks().containsKey(Attack.RADIOACTIVE_FIRE);
  }

  @Test
  public void testMonsterEntity2() {
    Monster monster = em.find(Monster.class, 2);
    LOGGER.info(monster.toString());
    assertNotNull(monster);
    assertEquals("Giant Badger", monster.getName());
    assertEquals(Size.MEDIUM, monster.getSize());
    assertEquals(2, monster.getAttacks().size());
    monster.getAttacks().containsKey(Attack.BITE);
    monster.getAttacks().containsKey(Attack.CLAW);
  }

  @Test
  public void testMonsterEntity3() {
    Monster monster = em.find(Monster.class, 3);
    LOGGER.info(monster.toString());
    assertNotNull(monster);
    assertEquals("Gremlin", monster.getName());
    assertEquals(Size.SMALL, monster.getSize());
    assertEquals(1, monster.getAttacks().size());
    monster.getAttacks().containsKey(Attack.MISCHIEF);
  }

  @Test
  public void testGetAll() {
    assertEquals(3, getAllMonsters().size());
  }

  @Test
  public void testPersist() {
    Monster monster = em.find(Monster.class, 10);
    assertNull(monster);

    em.getTransaction().begin();
    Monster tRex = new Monster(10, "Tyrannosaurus Rex", Size.MEDIUM);
    Damage tRexAttack = new Damage(10, Attack.BITE, 10);
    tRex.addAttack(tRexAttack);
    em.persist(tRex);
    em.getTransaction().commit();

    testNewMonsterEntity();
  }

  private void testNewMonsterEntity() {
    Monster monster = em.find(Monster.class, 10);
    LOGGER.info(monster.toString());
    assertNotNull(monster);
    assertEquals("Tyrannosaurus Rex", monster.getName());
    assertEquals(Size.MEDIUM, monster.getSize());
    assertEquals(1, monster.getAttacks().size());
    monster.getAttacks().containsKey(Attack.BITE);
  }

  @Test
  public void testDelete() {
    Monster monster = em.find(Monster.class, 1);

    em.getTransaction().begin();
    em.remove(monster);
    em.getTransaction().commit();

    assertEquals(2, getAllMonsters().size());
  }

}
