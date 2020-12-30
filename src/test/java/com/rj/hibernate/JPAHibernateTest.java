package com.rj.hibernate;

import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JPAHibernateTest {

  protected static EntityManagerFactory emf;
  protected static EntityManager em;

  @BeforeClass
  public static void init() {
    emf = Persistence.createEntityManagerFactory("monster-test");
    em = emf.createEntityManager();
  }

  @Before
  public void initializeDatabase() {
    Session session = em.unwrap(Session.class);
    session.doWork(connection -> {
      File script = new File(getClass().getResource("/data.sql").getFile());
      try (FileReader fileReader = new FileReader(script)) {
        RunScript.execute(connection, fileReader);
      } catch (IOException ioe) {
        throw new RuntimeException("Could not initialize with script!", ioe);
      }
    });
  }

  @AfterClass
  public static void tearDown() {
    em.clear();
    em.close();
    emf.close();
  }

}
