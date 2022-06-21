/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

public class GrowableList<E> {
  private Object[] data;

  public boolean add(E e) {
    throw new UnsupportedOperationException("Implement me");
  }

  public Object[] toArray() {
    throw new UnsupportedOperationException("Implement me");
  }
}