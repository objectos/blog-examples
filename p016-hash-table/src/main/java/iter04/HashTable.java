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
package iter04;

import java.util.Objects;

public class HashTable<K, V> extends iter03.HashTable<K, V> {
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

  protected V get0(Object key, int bucket, Object candidate) {
    throw new UnsupportedOperationException("Implement me");
  }
}