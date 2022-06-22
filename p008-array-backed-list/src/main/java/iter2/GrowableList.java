/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter2;

import java.util.Arrays;

public class GrowableList<E> {
  private static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

  private static final Object[] NO_DATA = new Object[0];

  private Object[] data = NO_DATA;

  private int size;

  public boolean add(E e) {
    if (data == NO_DATA) {
      data = new Object[10];
    }

    if (size < data.length) {
      return append(e);
    }

    int halfLength = data.length >> 1;

    int newLength = data.length + halfLength;

    if (newLength < 0) {
      newLength = SOFT_MAX_ARRAY_LENGTH;
    }

    data = Arrays.copyOf(data, newLength);

    return append(e);
  }

  public Object[] toArray() {
    return Arrays.copyOf(data, size);
  }

  private boolean append(E e) {
    data[size++] = e;

    return true;
  }
}