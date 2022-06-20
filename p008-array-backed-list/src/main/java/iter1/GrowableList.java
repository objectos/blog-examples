/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import java.util.Arrays;
import shared.AlwaysThrowList;

public class GrowableList<E> extends AlwaysThrowList<E> {
  protected Object[] data = initData();

  protected int size;

  @Override
  public boolean add(E e) {
    data[size++] = e;

    return true;
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(data, size);
  }

  protected Object[] initData() {
    return new Object[5];
  }
}