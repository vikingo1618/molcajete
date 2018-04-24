package com.axity.example.jpa.persistence.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.log4j.Logger;

/**
 * Clase abstracta que define los metodos de un dao
 */
public class GenericBaseDAOImpl<T>
{
  private static final Logger LOGGER = Logger.getLogger( GenericBaseDAOImpl.class );

  private static final String SELECT_COUNT_O_FROM = "select count(o) from ";
  private static final String AS_O = " as o";
  private static final String SELECT_OBJECT_O_FROM = "select object(o) from ";
  private static final String WHERE_O_ACTIVE = " where o.fgActive = 1";

  @PersistenceContext(unitName = "ExamplePersistenceUnit")
  private EntityManager entityManager;

  /**
   * Entidad
   */
  private Class<T> entityClass;

  /**
   * Constructor de la clase
   * 
   * @param entityClass
   */
  public GenericBaseDAOImpl( Class<T> entityClass )
  {
    this.entityClass = entityClass;
  }

  /**
   * Metodo insertar
   * 
   * @param entity
   */
  public void create( T entity )
  {
    getEntityManager().persist( entity );
    flush();
  }

  /**
   * Metodo editar o actualizar
   * 
   * @param entity
   */
  public void edit( T entity )
  {
    getEntityManager().merge( entity );
  }

  /**
   * Metodo Eliminar
   * 
   * @param entity
   */
  public void remove( T entity )
  {
    getEntityManager().remove( getEntityManager().merge( entity ) );
  }

  /**
   * Metodo de busqueda por Id
   * 
   * @param id
   * @return
   */
  public T find( Object id )
  {
    clearEntityCacheAll();
    return getEntityManager().find( entityClass, id );
  }

  /**
   * Metodo de busqueda por todos
   * 
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<T> findAll()
  {
    return getEntityManager().createQuery( SELECT_OBJECT_O_FROM + entityClass.getSimpleName() + AS_O ).getResultList();
  }

  /**
   * Metodo contador
   * 
   * @return
   */
  public int count()
  {
    return ((Long) getEntityManager().createQuery( SELECT_COUNT_O_FROM + entityClass.getSimpleName() + AS_O )
        .getSingleResult()).intValue();
  }

  /**
   * Fuerza el flush al entitymanager
   */
  public void flush()
  {
    getEntityManager().flush();
  }

  @SuppressWarnings("unchecked")
  public List<T> findAllActive()
  {
    return getEntityManager().createQuery( SELECT_OBJECT_O_FROM + entityClass.getSimpleName() + AS_O + WHERE_O_ACTIVE )
        .getResultList();
  }

  protected List<T> findByNamedQuery( TypedQuery<T> namedQuery )
  {
    clearEntityCacheAll();
    List<T> lista = null;
    try
    {
      lista = namedQuery.getResultList();
      if( lista == null )
      {
        lista = new ArrayList<T>();
      }
    }
    catch( Exception e )
    {
      LOGGER.error( "Error al ejecutar la query: " + namedQuery.toString(), e );
    }
    return lista;
  }

  @SuppressWarnings("unchecked")
  protected T getByNamedQuery( TypedQuery<T> namedQuery )
  {
    clearEntityCacheAll();
    List<T> lista = null;
    T element = null;
    try
    {
      lista = namedQuery.getResultList();
      if( CollectionUtils.isNotEmpty( lista ) )
      {
        element = (T) CollectionUtils.find( lista, PredicateUtils.notNullPredicate() );
      }
    }
    catch( Exception e )
    {
      LOGGER.error( "Error al ejecutar la query: " + namedQuery.toString(), e );
    }
    return element;
  }

  /**
   * @return the entityManager
   */
  protected EntityManager getEntityManager()
  {
    return entityManager;
  }

  /**
   * Method that clears the JPA cache for the current entity.
   * 
   * @author afuentes
   */
  public void clearEntityCache()
  {
    getEntityManager().getEntityManagerFactory().getCache().evict( entityClass );
  }

  /**
   * Method that clears the JPA cache for the current entity.
   * 
   * @author ctorresf
   */
  public void clearEntityCacheAll()
  {
    getEntityManager().getEntityManagerFactory().getCache().evictAll();
  }

}
