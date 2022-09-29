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
package iter13;

public class HashTable<K, V> extends iter12.HashTable<K, V> {
  private final float loadFactor;

  private int rehashSize;

  public HashTable() {
    super();

    loadFactor = 0.75f;

    rehashSize = (int) (keys.length * loadFactor);
  }

  @Override
  protected final V putInsert(K key, V value, int bucket) {
    V result = super.putInsert(key, value, bucket);

    if (size > rehashSize) {
      rehash();
    }

    return result;
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