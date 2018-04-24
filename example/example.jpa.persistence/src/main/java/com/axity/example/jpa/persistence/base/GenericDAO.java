package com.axity.example.jpa.persistence.base;

import java.util.List;

import com.axity.example.jpa.model.AbstractEntity;

/**
 * interface generica para DAOs
 * 
 * @author gsegura
 * @param <T>
 */
public interface GenericDAO<T extends AbstractEntity<T>>
{

  /**
   * Crea una entidad
   * 
   * @param entity
   */
  void create( T entity );

  /**
   * Edita una entidad
   * 
   * @param entity
   */
  void edit( T entity );

  /**
   * Elimina una entidad
   * 
   * @param entity
   */
  void remove( T entity );

  /**
   * Busca la entidad por su id
   * 
   * @param id
   * @return
   */
  T find( Object id );

  /**
   * Busca todas las entidades
   * 
   * @return
   */
  List<T> findAll();

  /**
   * Cuenta el número de entidades
   * 
   * @return
   */
  int count();

  /**
   * Obliga al Entity Manager a realizar flush
   */
  void flush();

  /**
   * Method that clears the JPA cache for the current entity.
   * 
   * @author ctorresf
   */
  void clearEntityCacheAll();

}
