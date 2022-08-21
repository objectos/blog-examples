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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VarargsNonReifiable2 {
  public static void main(String[] args) {
    @SuppressWarnings("unchecked")
    var set = asSet(new List[] {
        Arrays.asList("A", "B", "C"),
        Arrays.asList("B", "C", "D")});
    System.out.println(set);
  }

  @SuppressWarnings("unchecked")
  private static Set<String> asSet(List<String>... lists) {
    var set = new HashSet<String>();
    for (var list : lists) {
      for (var s : list) {
        set.add(s);
      }
    }
    return set;
  }
}