package com.rj.hibernate;

import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class JPAHibernateCRUDTest extends JPAHibernateTest {

  private List<Monster> getAllMonsters() {
    return em.createNamedQuery("Monster.getAll", Monster.class).getResultList();
  }

  @Test
  public void testInitialisedMonster() {
    Monster monster = em.find(Monster.class, 1);
    assertNotNull(monster);
    assertEquals("Godzilla", monster.getName());
    assertEquals(Size.LARGE, monster.getSize());
  }

  @Test
  public void testGetAll() {
    assertEquals(1, getAllMonsters().size());
  }

  @Test
  public void testPersist() {
    em.getTransaction().begin();
    em.persist(new Monster(10, "Sulley", Size.SMALL));
    em.getTransaction().commit();

    List<Monster> monsters = getAllMonsters();

    assertNotNull(monsters);
    assertEquals(2, monsters.size());
  }

  @Test
  public void testDelete_success() {
    Monster monster = em.find(Monster.class, 1);

    em.getTransaction().begin();
    em.remove(monster);
    em.getTransaction().commit();

    assertEquals(0, getAllMonsters().size());
  }

}
