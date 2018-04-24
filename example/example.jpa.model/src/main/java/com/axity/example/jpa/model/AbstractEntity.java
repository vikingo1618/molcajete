package com.axity.example.jpa.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * Clase padre de las entidades
 * 
 * @author gsegura
 */
@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable
{
  private static final long serialVersionUID = 6806342540005190482L;

  /**
   * {@inheritDoc}
   */
  public abstract boolean equals( Object object );

  /**
   * {@inheritDoc}
   */
  public abstract int hashCode();

  /**
   * {@inheritDoc}
   */
  public abstract String toString();
}
