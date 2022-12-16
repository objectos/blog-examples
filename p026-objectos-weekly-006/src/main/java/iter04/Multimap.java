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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class Multimap<K, V> {

  private final Map<K, Set<V>> map = new LinkedHashMap<>();

  public <R> Collection<R> entries(BiFunction<K, Set<V>, R> function) {
    return map.entrySet()
        .stream()
        .map(entry -> function.apply(entry.getKey(), entry.getValue()))
        .toList();
  }

  public void put(K key, V value) {
    var set = map.computeIfAbsent(key, k -> new TreeSet<>());

    if (value != null) {
      set.add(value);
    }
  }

}