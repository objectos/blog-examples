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
package iter6;

public class HashTable<K, V> extends iter5.HashTable<K, V> {
  @Override
  protected V put3(K key, V value, int bucket) {
    for (var index = 0; index < bucket; index++) {
      var existing = keys[index];

      if (existing == null) {
        return putInsert(key, value, index);
      }

      if (existing.equals(key)) {
        return putReplace(key, value, index);
      }
    }

    return put4(key, value, bucket);
  }

  private V put4(K key, V value, int bucket) {
    throw new AssertionError("Load factor not implemented?");
  }
}