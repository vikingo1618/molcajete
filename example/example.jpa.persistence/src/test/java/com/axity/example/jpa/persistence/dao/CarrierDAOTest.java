package com.axity.example.jpa.persistence.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.axity.example.jpa.model.CarrierDO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/initial-test-context.xml" })
@Transactional
public class CarrierDAOTest
{
  private static final Logger LOGGER = Logger.getLogger( CarrierDAOTest.class );

  @Autowired
  private CarrierDAO carrierDAO;

  @Test
  public void testFindByCode()
  {
    List<CarrierDO> airlines = this.carrierDAO.findByCode( "AV" );
    Assert.assertEquals( 1, airlines.size() );
  }

  @Test
  public void testFindByName()
  {
    List<CarrierDO> airlines = this.carrierDAO.findByName( "Avianca" );
    Assert.assertEquals( 1, airlines.size() );
  }

  @Test
  public void testFind()
  {
    CarrierDO airline = this.carrierDAO.find( 1 );
    Assert.assertNotNull( airline );
  }

  @Test
  public void testFindAll()
  {
    List<CarrierDO> airlines = carrierDAO.findAll();

    for( CarrierDO airline : airlines )
    {
      LOGGER.info( airline );
    }

  }

}
