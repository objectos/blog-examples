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
package set;

import java.util.Objects;

public class TweetSet<T> {

  private final Object[] data = new Object[8];

  private int size = 0;

  public boolean add(T value) {
    Objects.requireNonNull(value, "value == null");

    int bucket = bucket(value);

    var existing = data[bucket];

    if (existing == null) {
      return addNew(value, bucket);
    } else {
      return addIfNecessary(value, bucket, existing);
    }
  }

  public int size() {
    return size;
  }

  @Override
  public final String toString() {
    var sb = new StringBuilder();

    sb.append(
      """
      +-----+-----+
      | idx | val |
      +-----+-----+
      """
    );

    for (int idx = 0; idx < data.length; idx++) {
      var value = data[idx];

      if (value != null) {
        sb.append("| %3d | %3s |\n".formatted(idx, value, value));
      } else {
        sb.append("| %3d |     |\n".formatted(idx));
      }
    }

    sb.append("+-----+-----+\n");

    return sb.toString();
  }

  private boolean addIfNecessary(T value, int bucket, Object existing) {
    if (existing.equals(value)) {
      return false;
    } else {
      return addLinearProbe(value, bucket);
    }
  }

  private boolean addLinearProbe(T value, int bucket) {
    var index = bucket + 1;

    while (true) {
      if (index == data.length) {
        index = 0;
      }

      var existing = data[index];

      if (existing == null) {
        return addNew(value, index);
      }

      if (existing.equals(value)) {
        return false;
      }

      index++;
    }
  }

  private boolean addNew(T value, int bucket) {
    data[bucket] = value;

    size++;

    return true;
  }

  private int bucket(T value) {
    int hc = value.hashCode();

    return Math.floorMod(hc, data.length);
  }

}