/*
 * Copyright (C) 2022-2023 Objectos Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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