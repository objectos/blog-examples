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
package iter12b;

public class HashTable<K, V> extends iter11.HashTable<K, V> {
  @SuppressWarnings("unchecked")
  @Override
  protected final V get1(Object key, int bucket) {
    for (var i = bucket + 1; i < keys.length; i++) {
      var candidate = keys[i];

      if (candidate == null) {
        return null;
      }

      if (key.equals(candidate)) {
        return (V) values[i];
      }
    }

    for (var i = 0; i < bucket; i++) {
      var candidate = keys[i];

      if (candidate == null) {
        return null;
      }

      if (key.equals(candidate)) {
        return (V) values[i];
      }
    }

    throw new AssertionError();
  }
}