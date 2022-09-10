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
package iter1;

import java.util.Objects;

public class HashTable<K, V> {
  protected Object[] keys;

  protected Object[] values;

  protected int size;

  public HashTable() {
    keys = new Object[4];

    values = new Object[4];
  }

  @SuppressWarnings("unchecked")
  public final V get(K key) {
    Objects.requireNonNull(key);

    var bucket = bucket(key);

    var candidate = keys[bucket];

    if (key.equals(candidate)) {
      return (V) values[bucket];
    }

    return get1(key, bucket, candidate);
  }

  public final V put(K key, V value) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);

    resizeIfNecessary();

    var bucket = bucket(key);

    var existing = keys[bucket];

    if (existing == null) {
      return putInsert(key, value, bucket);
    }

    return put1(key, value, bucket, existing);
  }

  public int size() { return size; }

  protected int bucket(K key) {
    var hc = key.hashCode();

    return hc % keys.length;
  }

  protected V get1(K key, int bucket, Object candidate) {
    throw new UnsupportedOperationException("Implement me");
  }

  protected V put1(K key, V value, int bucket, Object existing) {
    throw new UnsupportedOperationException("Implement me");
  }

  protected final V putInsert(K key, V value, int bucket) {
    keys[bucket] = key;

    values[bucket] = value;

    size++;

    return null;
  }

  protected void resizeIfNecessary() { /* no-op */ }
}