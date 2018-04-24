package com.axity.example.jpa.persistence.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.axity.example.jpa.model.CarrierDO;
import com.axity.example.jpa.persistence.base.GenericBaseDAOImpl;
import com.axity.example.jpa.persistence.dao.CarrierDAO;

public class CarrierDAOImpl extends GenericBaseDAOImpl<CarrierDO> implements CarrierDAO
{

  /**
   * Constructor default
   */
  public CarrierDAOImpl()
  {
    super( CarrierDO.class );
  }

  @Override
  public List<CarrierDO> findByCode( String code )
  {
    TypedQuery<CarrierDO> namedQuery = super.getEntityManager().createNamedQuery( "CarrierDO.findByCode",
      CarrierDO.class );
    namedQuery.setParameter( "code", code );

    return findByNamedQuery( namedQuery );
  }

  @Override
  public List<CarrierDO> findByName( String name )
  {
    TypedQuery<CarrierDO> namedQuery = super.getEntityManager().createNamedQuery( "CarrierDO.findByName",
      CarrierDO.class );
    namedQuery.setParameter( "name", name );

    return findByNamedQuery( namedQuery );
  }
}
