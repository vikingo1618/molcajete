package com.axity.example.jpa.persistence.dao;

import java.util.List;

import com.axity.example.jpa.model.CarrierDO;
import com.axity.example.jpa.persistence.base.GenericDAO;

/**
 * DAO de la tabla C_AEROLINEA
 * 
 * @author gsegura
 */
public interface CarrierDAO extends GenericDAO<CarrierDO>
{

  /**
   * Busca los registros por el codigo
   * 
   * @param code
   * @return
   */
  List<CarrierDO> findByCode( String code );

  /**
   * Busca los registros por el nombre
   * 
   * @param name
   * @return
   */
  List<CarrierDO> findByName( String name );
}
