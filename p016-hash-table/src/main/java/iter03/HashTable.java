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
package iter03;

public class HashTable<K, V> extends iter02.HashTable<K, V> {
  protected Object[] keys = new Object[4];

  protected Object[] values = new Object[4];

  protected int bucket(Object key) {
    var hc = key.hashCode();

    return hc % keys.length;
  }

  @Override
  protected final V put0(K key, V value) {
    var bucket = bucket(key);

    var existing = keys[bucket];

    if (existing == null) {
      return putInsert(key, value, bucket);
    }

    return put1(key, value, bucket, existing);
  }

  protected V put1(K key, V value, int bucket, Object existing) {
    throw new UnsupportedOperationException("Implement me");
  }

  protected V putInsert(K key, V value, int bucket) {
    keys[bucket] = key;

    values[bucket] = value;

    size++;

    return null;
  }
}