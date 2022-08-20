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
package iter4;

import java.util.HashSet;
import java.util.Set;

public class DistinctGeneric {
  public static void main(String... args) {
    var set = asSet("A", "B", "B", "C", "C", "C");

    System.out.println("Distinct arguments are:");
    System.out.println(set);
  }

  @SafeVarargs
  private static <E> Set<E> asSet(E... values) {
    var set = new HashSet<E>();
    for (var value : values) {
      set.add(value);
    }
    return set;
  }
}