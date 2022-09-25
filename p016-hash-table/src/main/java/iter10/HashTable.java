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
package iter10;

public class HashTable<K, V> extends iter09.HashTable<K, V> {
  @Override
  protected V put2(K key, V value, int bucket) {
    for (var index = bucket + 1; index < keys.length; index++) {
      var existing = keys[index];

      if (existing == null) {
        return putInsert(key, value, index);
      }
    }

    for (var index = 0; index < bucket; index++) {
      var existing = keys[index];

      if (existing == null) {
        return putInsert(key, value, index);
      }
    }

    throw new UnsupportedOperationException("Implement me");
  }
}