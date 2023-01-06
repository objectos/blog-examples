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
package iter13;

import java.util.Arrays;

final class HashTable<K, V> extends iter12.HashTable<K, V> {
  @Override
  protected final V putInsert(K key, V value, int bucket) {
    V result = super.putInsert(key, value, bucket);

    if (size == keys.length) {
      resize();
    }

    return result;
  }

  private void resize() {
    var newLength = keys.length << 1;

    keys = Arrays.copyOf(keys, newLength);

    values = Arrays.copyOf(values, newLength);
  }
}