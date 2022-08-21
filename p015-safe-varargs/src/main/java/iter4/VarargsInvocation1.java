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

public class VarargsInvocation1 {
  public static void main(String[] args) {
    var set = asSet("A", "B", "B", "C", "C");
    System.out.println(set);
  }

  private static Set<String> asSet(String... strings) {
    var set = new HashSet<String>();
    for (String s : strings) {
      set.add(s);
    }
    return set;
  }
}