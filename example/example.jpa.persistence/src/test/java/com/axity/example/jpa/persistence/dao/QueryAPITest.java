package com.axity.example.jpa.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/initial-test-context.xml" })
@Transactional
public class QueryAPITest
{

  @PersistenceContext(unitName = "ExamplePersistenceUnit")
  private EntityManager entityManager;

  @Test
  public void testCreateQuery()
  {
    Query query = entityManager.createQuery( "SELECT o FROM CarrierDO o" );

    List result = query.getResultList();
    Assert.assertNotNull( result );
    for( Object o : result )
    {
      System.out.println( o );
    }

  }
  
  @Test
  public void testCreateQueryWithParams()
  {
    Query query = entityManager.createQuery( "SELECT o FROM CarrierDO o WHERE o.code = :code" );
    query.setParameter( "code", "AV" );
    List result = query.getResultList();
    Assert.assertNotNull( result );
    for( Object o : result )
    {
      System.out.println( o );
    }

  }

}
