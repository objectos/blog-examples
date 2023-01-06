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
package iter12;

public class HashTable<K, V> extends iter11.HashTable<K, V> {
  @SuppressWarnings("unchecked")
  @Override
  protected final V get1(Object key, int bucket) {
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
}