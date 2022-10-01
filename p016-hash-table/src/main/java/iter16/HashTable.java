/*
 * Copyright (C) 2022 Objectos Software LTDA.
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
package iter16;

import java.util.Objects;

public final class HashTable<K, V> {
  private int size;

  private final float loadFactor;

  private int rehashSize;

  private Object[] keys = new Object[4];

  private Object[] values = new Object[4];

  public HashTable() {
    loadFactor = 0.75f;

    rehashSize = (int) (keys.length * loadFactor);
  }

  @SuppressWarnings("unchecked")
  public final V get(Object key) {
    Objects.requireNonNull(key, "key == null");

    var bucket = bucket(key);

    var candidate = keys[bucket];

    if (key.equals(candidate)) {
      return (V) values[bucket];
    }

    return get0(key, bucket, candidate);
  }

  public final V put(K key, V value) {
    Objects.requireNonNull(key, "key == null");
    Objects.requireNonNull(value, "value == null");

    return put0(key, value);
  }

  public final int size() { return size; }

  @Override
  public final String toString() {
    var sb = new StringBuilder();

    sb.append(
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      """);

    for (int idx = 0; idx < keys.length; idx++) {
      var key = keys[idx];

      if (key != null) {
        var value = values[idx];

        sb.append("| %3d | %3s | %3s |\n".formatted(idx, key, value));
      } else {
        sb.append("| %3d |     |     |\n".formatted(idx));
      }
    }

    sb.append("+-----+-----+-----+\n");

    return sb.toString();
  }

  private int bucket(Object key) {
    var hc = key.hashCode();

    hc = hc ^ (hc >>> 16);

    var mask = keys.length - 1;

    return hc & mask;
  }

  private V get0(Object key, int bucket, Object candidate) {
    if (candidate == null) {
      return null;
    }

    return get1(key, bucket);
  }

  @SuppressWarnings("unchecked")
  private V get1(Object key, int bucket) {
    var index = bucket + 1;

    while (true) {
      if (index == keys.length) {
        index = 0;
      }

      var existing = keys[index];

      if (existing == null) {
        return null;
      }

      if (key.equals(existing)) {
        return (V) values[index];
      }

      index++;
    }
  }

  private V put0(K key, V value) {
    var bucket = bucket(key);

    var existing = keys[bucket];

    if (existing == null) {
      return putInsert(key, value, bucket);
    }

    return put1(key, value, bucket, existing);
  }

  private V put1(K key, V value, int bucket, Object existing) {
    if (existing.equals(key)) {
      return putReplace(key, value, bucket);
    }

    return put2(key, value, bucket);
  }

  private V put2(K key, V value, int bucket) {
    var index = bucket + 1;

    while (true) {
      if (index == keys.length) {
        index = 0;
      }

      var existing = keys[index];

      if (existing == null) {
        return putInsert(key, value, index);
      }

      if (existing.equals(key)) {
        return putReplace(key, value, index);
      }

      index++;
    }
  }

  private V putInsert(K key, V value, int bucket) {
    keys[bucket] = key;

    values[bucket] = value;

    size++;

    if (size > rehashSize) {
      rehash();
    }

    return null;
  }

  @SuppressWarnings("unchecked")
  private V putReplace(K key, V value, int bucket) {
    var oldValue = values[bucket];

    keys[bucket] = key;

    values[bucket] = value;

    return (V) oldValue;
  }

  @SuppressWarnings("unchecked")
  private void rehash() {
    var newLength = keys.length << 1;

    if (newLength < 0) {
      throw new OutOfMemoryError();
    }

    var oldKeys = keys;

    var oldValues = values;

    keys = new Object[newLength];

    values = new Object[newLength];

    rehashSize = (int) (keys.length * loadFactor);

    size = 0;

    for (int i = 0; i < oldKeys.length; i++) {
      var key = oldKeys[i];

      if (key == null) {
        continue;
      }

      var value = oldValues[i];

      put0((K) key, (V) value);
    }
  }

}