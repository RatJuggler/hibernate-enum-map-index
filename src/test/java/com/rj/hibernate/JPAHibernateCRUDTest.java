package com.rj.hibernate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

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
  }

  @Test
  public void testMonsterEntity2() {
    Monster monster = em.find(Monster.class, 2);
    LOGGER.info(monster.toString());
    assertNotNull(monster);
    assertEquals("Giant Badger", monster.getName());
    assertEquals(Size.MEDIUM, monster.getSize());
    assertEquals(2, monster.getAttacks().size());
  }

  @Test
  public void testMonsterEntity3() {
    Monster monster = em.find(Monster.class, 3);
    LOGGER.info(monster.toString());
    assertNotNull(monster);
    assertEquals("Gremlin", monster.getName());
    assertEquals(Size.SMALL, monster.getSize());
    assertEquals(1, monster.getAttacks().size());
  }

  @Test
  public void testGetAll() {
    assertEquals(3, getAllMonsters().size());
  }

  @Test
  public void testPersist() {
    em.getTransaction().begin();
    Monster tRex = new Monster(10, "Tyrannosaurus Rex", Size.MEDIUM);
    Damage tRexAttack = new Damage(10, Attack.BITE, 10);
    tRex.addAttack(tRexAttack);
    em.persist(tRex);
    em.getTransaction().commit();

    List<Monster> monsters = getAllMonsters();

    assertNotNull(monsters);
    assertEquals(4, monsters.size());
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
