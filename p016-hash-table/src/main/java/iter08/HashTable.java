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
package iter08;

public class HashTable<K, V> extends iter07b.HashTable<K, V> {
  @Override
  public final String toString() {
    var sb = new StringBuilder();

    sb.append(
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      """);

    for (int idx = 0; idx < keys.length; idx++) {
      var key = keys[idx];

      if (key != null) {
        var value = values[idx];

        sb.append("| %3d | %3s | %3s |\n".formatted(idx, key, value));
      } else {
        sb.append("| %3d |     |     |\n".formatted(idx));
      }
    }

    sb.append("+-----+-----+-----+\n");

    return sb.toString();
  }
}