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

    if (0 < newLength && newLength <= SOFT_MAX_ARRAY_LENGTH) {
      grow(newLength);

      return append(e);
    }

    int minLength = data.length + 1;

    if (minLength < 0) {
      throw new OutOfMemoryError();
    } else if (minLength <= SOFT_MAX_ARRAY_LENGTH) {
      grow(SOFT_MAX_ARRAY_LENGTH);
    } else {
      grow(minLength);
    }

    return append(e);
  }

  public Object[] toArray() {
    return Arrays.copyOf(data, size);
  }

  private boolean append(E e) {
    data[size++] = e;

    return true;
  }

  private void grow(int newLength) {
    data = Arrays.copyOf(data, newLength);
  }
}