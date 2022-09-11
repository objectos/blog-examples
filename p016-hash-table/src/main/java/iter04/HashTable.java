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
package iter04;

public class HashTable<K, V> extends iter03.HashTable<K, V> {
  @Override
  protected final V put1(K key, V value, int bucket, Object existing) {
    if (existing.equals(key)) {
      return putReplace(key, value, bucket);
    }

    return put2(key, value, bucket);
  }

  protected V put2(K key, V value, int bucket) {
    throw new UnsupportedOperationException("Implement me");
  }

  @SuppressWarnings("unchecked")
  protected final V putReplace(K key, V value, int bucket) {
    var oldValue = values[bucket];

    keys[bucket] = key;

    values[bucket] = value;

    return (V) oldValue;
  }
}