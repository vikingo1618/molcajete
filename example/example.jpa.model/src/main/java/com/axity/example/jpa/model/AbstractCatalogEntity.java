package com.axity.example.jpa.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Clase padre de los catalogos
 * 
 * @author gsegura
 * @param <T>
 */
@MappedSuperclass
public abstract class AbstractCatalogEntity<T> extends AbstractEntity<T>
{
  private static final long serialVersionUID = -3278951552115321860L;

  @Column(name = "DS_NOMBRE")
  protected String name;

  @Column(name = "DS_CODIGO")
  protected String code;

  /**
   * @return the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName( String name )
  {
    this.name = name;
  }

  /**
   * @return the code
   */
  public String getCode()
  {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode( String code )
  {
    this.code = code;
  }

}
